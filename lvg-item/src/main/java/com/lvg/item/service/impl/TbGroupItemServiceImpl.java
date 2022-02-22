package com.lvg.item.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.alibaba.dubbo.config.annotation.Reference;
import com.lvg.commons.pojo.LvgResult;
import com.lvg.commons.pojo.TbGroupItemChild;
import com.lvg.commons.pojo.WxDataGrid;
import com.lvg.commons.utils.HttpClientUtil;
import com.lvg.commons.utils.IDUtils;
import com.lvg.commons.utils.JsonUtils;
import com.lvg.dubbo.service.TbGroupDubboService;
import com.lvg.dubbo.service.TbGroupItemDubboService;
import com.lvg.dubbo.service.TbUserDubboService;
import com.lvg.item.service.TbGroupItemService;
import com.lvg.pojo.TbGroup;
import com.lvg.pojo.TbGroupItem;
import com.lvg.pojo.TbUser;
import com.lvg.redis.dao.JedisDao;

@Service
public class TbGroupItemServiceImpl implements TbGroupItemService {
	@Reference
	private TbGroupItemDubboService tbGroupItemDubboServiceImpl;
	
	@Reference
	private TbGroupDubboService tbGroupDubboServiceImpl;
	
	@Reference
    private TbUserDubboService tbUserDubboServiceImpl;
	
	@Resource
	private JedisDao jedisDaoImpl;
	
	@Value("${redis.item.key}")
	private String itemKey;
	
	@Value("${search.addUrl}")
	private String addUrl;
	
	@Value("${search.delUrl}")
	private String delUrl;

	@Override
	public String getItemDetail(long uid, long iid) {
		TbGroupItemChild child = new TbGroupItemChild();
		//redis是否有缓存
		String key = itemKey + iid;
		if(jedisDaoImpl.exists(key)) {
			String itemJson = jedisDaoImpl.get(key);
			if(itemJson!=null && !itemJson.equals("")) {
				child = JsonUtils.jsonToPojo(itemJson, TbGroupItemChild.class);
			}
		} else {
			TbGroupItem item = tbGroupItemDubboServiceImpl.selById(iid);
	 		TbGroup group = tbGroupDubboServiceImpl.selById(item.getGroupId());
	 		long hostId =group.getHostId();
	 		child.setId(iid);
	 		child.setHostId(hostId);
	 		child.setTitle(item.getTitle());
	 		child.setType(item.getType());
	 		child.setPrice(item.getPrice());
	 		child.setPeople(item.getPeople());
	 		child.setEvaluation(item.getEvaluation());
	 		child.setRoom(item.getRoom());
	 		child.setToilet(item.getToilet());
	 		child.setDiscount(item.getDiscount());
	 		child.setProvince(group.getProvince());
	 		child.setCity(group.getCity());
	 		child.setAdress(group.getAdress());
	 		child.setRestype(group.getRestype());
	 		child.setIntroduce(group.getIntroduce());
	 		//房源图片+房型图片
			String image = item.getImage() + group.getImage();
			String[] images = (image==null||image.equals("")?new String[1]:image.split(","));
			child.setImages(images);
			//多少张床
			String beds = item.getBeds();
			int num = 0;
			if(beds!=null && !beds.equals("")) {
				num = item.getBeds().split(",").length;
				//床的参数数组
				child.setBedsArra(item.getBeds().split(","));
			}
			child.setBedNum(num);
			//设施数组
			String infrast = item.getInfrast();
			if(infrast!=null && !infrast.equals("")) {
				child.setInfrastArra(infrast.split(","));
			}
			String safefaci = item.getSafefaci();
			if(safefaci!=null && !safefaci.equals("")) {
				child.setSafefaciArra(safefaci.split(","));
			}
			String supfaci = group.getSupfaci();
			if(supfaci!=null && !supfaci.equals("")) {
				child.setSupfaciArra(supfaci.split(","));
			}
			//获取房东的头像
			TbUser hostUser = tbUserDubboServiceImpl.selById(hostId);
			child.setHostImage(hostUser.getImage());
			//缓存到redis中
			jedisDaoImpl.set(key, JsonUtils.objectToJson(child));
		}
 		
		//是否被收藏
		TbUser userObj = null;
		if(uid!=0) {
			userObj = tbUserDubboServiceImpl.selById(uid);
		}
		child.setCollect(false);
		if(userObj!=null) {
			String is = userObj.getCollect();
			if(is!=null && !is.equals("")) {
				String[] arryStr = is.split(",");
				for (String str : arryStr) {
					if(str.equals(""+iid)) {
						child.setCollect(true);
						break;
					}
				}
			}
		}
		LvgResult result = new LvgResult();
		result.setData(child);
		return JsonUtils.objectToJson(result);
	}

	@Override
	public LvgResult addItem(String itemJson) {
		TbGroupItem item = JsonUtils.jsonToPojo(itemJson, TbGroupItem.class);
		item.setId(IDUtils.genItemId());
		item.setEvaluation(0);
		Date date = new Date();
		item.setCreated(date);
		item.setUpdated(date);
		int flag = tbGroupItemDubboServiceImpl.insTbGroupItem(item);
		LvgResult result = new LvgResult();
		if(flag==1) {
			result.setStatus(200);
			//solr同步新增
			final TbGroupItem finalItem = item;
			new Thread() {
				public void run() {
					Map<String, Object> map = new HashMap<>();
					map.put("item", finalItem);
					HttpClientUtil.doPostJson(addUrl, JsonUtils.objectToJson(map));
				}
			}.start();
		}
		return result;
	}

	@Override
	public WxDataGrid getList(long gid) {
		List<TbGroupItem> list = tbGroupItemDubboServiceImpl.selByGroupId(gid);
		WxDataGrid dataGrid = new WxDataGrid();
		dataGrid.setRows(list);
		dataGrid.setStatus(200);
		dataGrid.setTotal(list.size());
		return dataGrid;
	}

	@Override
	public LvgResult updItem(String itemJson) {
		TbGroupItem item = JsonUtils.jsonToPojo(itemJson, TbGroupItem.class);
		Date date = new Date();
		item.setUpdated(date);
		int flag = tbGroupItemDubboServiceImpl.updTbGroupItem(item);
		LvgResult result = new LvgResult();
		if(flag>0) {
			result.setStatus(200);
			//如果有缓存，删除之前的redis缓存
			String key = itemKey + item.getId();
			if(jedisDaoImpl.exists(key)) {				
				jedisDaoImpl.del(key);
			}
			//solr同步更新
			final TbGroupItem finalItem = tbGroupItemDubboServiceImpl.selById(item.getId());
			new Thread() {
				public void run() {
					Map<String, Object> map = new HashMap<>();
					map.put("item", finalItem);
					HttpClientUtil.doPostJson(addUrl, JsonUtils.objectToJson(map));
				}
			}.start();
		}
		return result;
	}

}
