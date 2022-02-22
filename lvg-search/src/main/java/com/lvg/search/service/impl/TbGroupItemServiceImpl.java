package com.lvg.search.service.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrQuery.ORDER;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.CloudSolrClient;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.client.solrj.response.UpdateResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.apache.solr.common.SolrInputDocument;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.alibaba.dubbo.config.annotation.Reference;
import com.lvg.commons.pojo.TbGroupItemChild;
import com.lvg.commons.pojo.WxDataGrid;
import com.lvg.commons.utils.HttpClientUtil;
import com.lvg.commons.utils.JsonUtils;
import com.lvg.dubbo.service.TbGroupDubboService;
import com.lvg.dubbo.service.TbGroupItemDubboService;
import com.lvg.dubbo.service.TbUserDubboService;
import com.lvg.pojo.TbGroup;
import com.lvg.pojo.TbGroupItem;
import com.lvg.pojo.TbUser;
import com.lvg.search.pojo.QueryEntity;
import com.lvg.search.service.TbGroupItemService;


@Service
public class TbGroupItemServiceImpl implements TbGroupItemService{
	@Reference
	private TbGroupItemDubboService tbGroupItemDubboServiceImpl;
	
	@Reference
	private TbGroupDubboService tbGroupDubboServiceImpl;
	
	@Reference
	private TbUserDubboService tbUserDubboServiceImpl;
	
	@Resource
	private CloudSolrClient solrClient;
	
	@Value("${order.getBookdateUrl}")
	private String url;

	@Override
	public void init() throws SolrServerException, IOException {
		solrClient.deleteByQuery("*:*");
		solrClient.commit();
		
		//查询所有正常的房型
		List<TbGroupItem> listItem = tbGroupItemDubboServiceImpl.selAllByStatus((byte)1);
		for(TbGroupItem item:listItem){
			SolrInputDocument doc = solrInput(item);
			solrClient.add(doc);
		}
		solrClient.commit();
	}

	@Override
	public WxDataGrid search(long uid, String query, String intime, String outtime, int page, int rows, boolean hasMore)
			throws SolrServerException, IOException {
		System.out.println(uid);
		System.out.println(query);
		TbUser userObj = null;
		if(uid!=0) {
			userObj = tbUserDubboServiceImpl.selById(uid);
		}
		QueryEntity queryObj = null;
		if(query!=null && !query.equals("")) {
			queryObj = JsonUtils.jsonToPojo(query, QueryEntity.class);
		}

		WxDataGrid datagrid = new WxDataGrid();
		if(hasMore) {
			//创建查询体
			SolrQuery params = new SolrQuery();
			//设置分页条件
			params.setStart(rows*(page-1));
			params.setRows(rows);
			//设置查询条件
			StringBuilder sb = new StringBuilder("*:*");
			if(queryObj!=null) {
				sb.append(" && item_keywords:" + (queryObj.getKeywords()!=null && queryObj.getKeywords()!=""?queryObj.getKeywords():"*"));
				sb.append(" && item_people:" + (queryObj.getPeople()!=0?(queryObj.getPeople()==8?"["+queryObj.getPeople()+" TO *]":queryObj.getPeople()):"*"));
				sb.append(" && item_price:" + ((queryObj.getMinprice()==0 && queryObj.getMaxprice()==501) || queryObj.getMaxprice()==0?"*":"["+queryObj.getMinprice()+" TO "+(queryObj.getMaxprice()==501?"*":queryObj.getMaxprice())+"]"));
				sb.append(" && item_room:" +(queryObj.getRoom()!=0?queryObj.getRoom():"*"));
				sb.append(" && item_beds:" +(queryObj.getBeds()!=0?queryObj.getBeds():"*"));
				sb.append(" && item_toilet:" + (queryObj.getToilet()!=0?queryObj.getToilet():"*"));
				sb.append(" && item_type:" + (queryObj.getType()!=null && queryObj.getType()!=""?queryObj.getType():"*"));
				// 基础设施筛选
				String[] infrast = queryObj.getInfrast();
				if(infrast.length>0) {
					for (String str : infrast) {
						sb.append(" && item_infrast:"+"\""+str+"\"");
					}
				} else {
					sb.append(" && item_infrast:*");
				}
				// 安全设施筛选
				String[] safefaci = queryObj.getSafefaci();
				if(safefaci.length>0) {
					for (String str : safefaci) {
						sb.append(" && item_safefaci:"+"\""+str+"\"");
					}
				} else {
					sb.append(" && item_safefaci:*");
				}
				// 配套设施筛选
				String[] supfaci = queryObj.getSupfaci();
				if(supfaci.length>0) {
					for (String str : supfaci) {
						sb.append(" && item_supfaci:"+"\""+str+"\"");
					}
				} else {
					sb.append(" && item_supfaci:*");
				}
			}
			System.out.println(sb.toString());
			params.setQuery(sb.toString());

			//添加排序
			if(queryObj!=null && queryObj.getFieldname()!="") {
				params.setSort(queryObj.getFieldname(), queryObj.isDesc()?ORDER.desc:ORDER.asc);			
			}else {
				params.setSort("item_updated", ORDER.desc);
			}
			//获取查询结果
			QueryResponse response = solrClient.query(params);
			SolrDocumentList listSolr = response.getResults();
			long numFound = listSolr.getNumFound();
			
			List<TbGroupItemChild> listChild = new ArrayList<>();
			for (SolrDocument doc : listSolr) {
				TbGroupItemChild child = new TbGroupItemChild();
				long itemId = Long.parseLong(doc.getFieldValue("id").toString());
				//预定日期筛选
				boolean flag = false;
				if(!intime.equals("") && !outtime.equals("")) {
					String bookdate = HttpClientUtil.doPost(url+"?iid="+itemId);
					String[] bookdateArray = JsonUtils.jsonToPojo(bookdate, String[].class);
					for(String date:bookdateArray) {
						if(Long.parseLong(date)>=Long.parseLong(intime) && Long.parseLong(date)<Long.parseLong(outtime)) {
							flag = true;
							numFound--;
							break;
						}
					}
				}
				if(flag) continue;
				child.setId(itemId);
				child.setTitle(doc.getFieldValue("item_title").toString());
				child.setPrice(Integer.parseInt(doc.getFieldValue("item_price").toString()));
				child.setPeople(Integer.parseInt(doc.getFieldValue("item_people").toString()));
				child.setRestype(doc.getFieldValue("item_restype").toString());
				child.setType(doc.getFieldValue("item_type").toString());
				child.setRoom(Integer.parseInt(doc.getFieldValue("item_room").toString()));
				child.setBedNum(Integer.parseInt(doc.getFieldValue("item_beds").toString()));
				child.setToilet(Integer.parseInt(doc.getFieldValue("item_toilet").toString()));
				child.setEvaluation(Integer.parseInt(doc.getFieldValue("item_eval").toString()));

				String image = doc.getFieldValue("item_image").toString();
				String[] images = (image==null||image.equals("")?new String[1]:image.split(","));
				child.setImages(images);
				
				//获取房东的头像
				long hostId = Long.parseLong(doc.getFieldValue("item_hostid").toString());
				child.setHostId(hostId);
				TbUser hostUser = tbUserDubboServiceImpl.selById(hostId);
				child.setHostImage(hostUser.getImage());
				
				//是否被收藏
				child.setCollect(false);
				if(userObj!=null) {
					String is = userObj.getCollect();
					if(is!=null && !is.equals("")) {
						String[] arryStr = is.split(",");
						for (String str : arryStr) {
							if(str.equals(""+itemId)) {
								child.setCollect(true);
								break;
							}
						}
					}
				}
				
				listChild.add(child);
			}
			datagrid.setRows(listChild);
			datagrid.setHasMore(true);
			long totalPages = (numFound%rows==0?numFound/rows:numFound/rows+1);
			if(page>=totalPages) {
				datagrid.setHasMore(false);
			}
			datagrid.setTotal(numFound);
			datagrid.setStatus(200);
		}
		return datagrid;
	}

	@Override
	public int addOrUpd(Map<String, TbGroupItem> map) throws SolrServerException, IOException {
		TbGroupItem item = map.get("item");
		SolrInputDocument doc = solrInput(item);
		UpdateResponse response = solrClient.add(doc);
		solrClient.commit();
		if(response.getStatus()==0){
			//新增或修改成功
			return 1;
		}
		return 0;
	}
	
	@Override
	public void delete(String iid) throws SolrServerException, IOException {
		solrClient.deleteById(iid);
	}
	
	private SolrInputDocument solrInput(TbGroupItem item) {
		//房型对应的房源信息
		TbGroup group = tbGroupDubboServiceImpl.selById(item.getGroupId());
		SolrInputDocument doc = new SolrInputDocument();
		doc.setField("id", item.getId());// 如果id相同，则执行更新操作
		doc.setField("item_title", item.getTitle());
		doc.setField("item_hostid", group.getHostId());
		doc.setField("item_province", group.getProvince());
		doc.setField("item_city", group.getCity());
		doc.setField("item_adress", group.getAdress());
		doc.setField("item_price", item.getPrice());
		doc.setField("item_people", item.getPeople());
		doc.setField("item_eval", item.getEvaluation());
		doc.setField("item_restype", group.getRestype());
		doc.setField("item_type", item.getType());
		doc.setField("item_room", item.getRoom());
		doc.setField("item_toilet", item.getToilet());
		doc.setField("item_infrast", item.getInfrast());
		doc.setField("item_safefaci", item.getSafefaci());
		doc.setField("item_supfaci", group.getSupfaci());
		doc.setField("item_updated", item.getUpdated());
		//房源图片+房型图片
		String images = item.getImage() + group.getImage();
		doc.setField("item_image", images);
		//多少张床
		String beds = item.getBeds();
		int num = (beds==null || beds.equals("")?0:beds.split(",").length);
		doc.setField("item_beds", num);
		return doc;
	}
}
