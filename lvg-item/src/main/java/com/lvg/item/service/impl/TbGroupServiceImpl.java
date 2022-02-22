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
import com.lvg.commons.pojo.WxDataGrid;
import com.lvg.commons.utils.HttpClientUtil;
import com.lvg.commons.utils.IDUtils;
import com.lvg.commons.utils.JsonUtils;
import com.lvg.dubbo.service.TbGroupDubboService;
import com.lvg.dubbo.service.TbGroupItemDubboService;
import com.lvg.item.service.TbGroupService;
import com.lvg.pojo.TbGroup;
import com.lvg.pojo.TbGroupItem;
import com.lvg.redis.dao.JedisDao;
import com.lvg.redis.dao.impl.JedisDaoImpl;

@Service
public class TbGroupServiceImpl implements TbGroupService {
	@Reference
	private TbGroupDubboService tbGroupDubboServiceImpl;
	
	@Reference 
	private TbGroupItemDubboService tbGroupItemDubboServiceImpl;
	
	@Resource
	private JedisDao jedisDaoImpl;
	
	@Value("${redis.item.key}")
	private String itemKey;
	
	@Value("${search.addUrl}")
	private String addUrl;
	
	@Value("${search.delUrl}")
	private String delUrl;

	@Override
	public LvgResult addGroup(String groupJson) {
		TbGroup group = JsonUtils.jsonToPojo(groupJson, TbGroup.class);
		group.setId(IDUtils.genItemId());
		Date date = new Date();
		group.setCreated(date);
		group.setUpdated(date);
		int flag = tbGroupDubboServiceImpl.insTbGroup(group);
		LvgResult result = new LvgResult();
		if(flag==1) {
			result.setStatus(200);
		}
		return result;
	}

	@Override
	public WxDataGrid getList(long uid) {
		List<TbGroup> list = tbGroupDubboServiceImpl.selByUid(uid);
		WxDataGrid dataGrid = new WxDataGrid();
		dataGrid.setRows(list);
		dataGrid.setStatus(200);
		dataGrid.setTotal(list.size());
		return dataGrid;
	}

	@Override
	public LvgResult updGroup(String groupJson) {
		TbGroup group = JsonUtils.jsonToPojo(groupJson, TbGroup.class);
		Date date = new Date();
		group.setUpdated(date);
		int flag = tbGroupDubboServiceImpl.updTbGroup(group);
		LvgResult result = new LvgResult();
		if(flag>0) {
			result.setStatus(200);
			final List<TbGroupItem> list = tbGroupItemDubboServiceImpl.selByGroupId(group.getId());
			//solr同步更新
			new Thread() {
				public void run() {
					for(TbGroupItem item:list) {
						//如果房源下的房型有缓存，删除之前的redis缓存
						String key = itemKey + item.getId();
						if(jedisDaoImpl.exists(key)) {
							jedisDaoImpl.del(key);
						}
						Map<String, Object> map = new HashMap<>();
						map.put("item", item);
						HttpClientUtil.doPostJson(addUrl, JsonUtils.objectToJson(map));
					}
				}
			}.start();
		}
		return result;
	}
}
