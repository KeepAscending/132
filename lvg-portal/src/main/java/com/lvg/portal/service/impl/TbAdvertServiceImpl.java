package com.lvg.portal.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.alibaba.dubbo.config.annotation.Reference;
import com.lvg.commons.utils.JsonUtils;
import com.lvg.dubbo.service.TbAdvertDubboService;
import com.lvg.pojo.TbAdvert;
import com.lvg.portal.service.TbAdvertService;
import com.lvg.redis.dao.JedisDao;

@Service
public class TbAdvertServiceImpl implements TbAdvertService {
    @Reference
	private TbAdvertDubboService tbAdvertDubboServiceImpl;
    
    @Resource
    private JedisDao jedisdaoImpl;
    
    @Value("${redis.advert.key}")
    private String key;

	@Override
	public String showAdvert(int count, boolean isSort) {
		
		//判断在 redis 中是否有缓存
		if(jedisdaoImpl.exists(key)) {
			String value = jedisdaoImpl.get(key);
			List<TbAdvert> list = JsonUtils.jsonToList(value, TbAdvert.class);
			if(value!=null && !value.equals("") && list.size()==count) {
				return value;
			}
		}
		//不存在缓存就从 mysql 中取，并加入缓存
		List<TbAdvert> list = tbAdvertDubboServiceImpl.selByCount(count, isSort);
		String listJson = JsonUtils.objectToJson(list);
		jedisdaoImpl.set(key, listJson);
		return	listJson;
	}
	
	
}
