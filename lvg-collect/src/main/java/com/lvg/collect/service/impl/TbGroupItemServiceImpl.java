package com.lvg.collect.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.alibaba.dubbo.config.annotation.Reference;
import com.lvg.collect.service.TbGroupItemService;
import com.lvg.commons.pojo.TbGroupItemChild;
import com.lvg.commons.utils.JsonUtils;
import com.lvg.dubbo.service.TbGroupDubboService;
import com.lvg.dubbo.service.TbGroupItemDubboService;
import com.lvg.dubbo.service.TbUserDubboService;
import com.lvg.pojo.TbGroup;
import com.lvg.pojo.TbGroupItem;
import com.lvg.pojo.TbUser;

@Service
public class TbGroupItemServiceImpl implements TbGroupItemService {
	@Reference
	private TbGroupItemDubboService tbGroupItemDubboServiceImpl;
	
	@Reference
	private TbGroupDubboService tbGroupDubboServiceImpl;
	
	@Reference
    private TbUserDubboService tbUserDubboServiceImpl;

	@Override
	public String getCollectList(long uid) {
		List<TbGroupItemChild> childList = new ArrayList<>();
		TbUser user = tbUserDubboServiceImpl.selById(uid);
		String collect = user.getCollect();
		if(collect!=null && !collect.equals("")) {
			String[] arr = collect.split(",");
			for (String str : arr) {
				TbGroupItemChild child = new TbGroupItemChild();
				
				TbGroupItem item = tbGroupItemDubboServiceImpl.selById(Long.parseLong(str));
				child.setId(item.getId());
				child.setTitle(item.getTitle());
				child.setPrice(item.getPrice());
				child.setEvaluation(item.getEvaluation());
				String image = item.getImage();
				String[] images = (image==null||image.equals("")?new String[1]:image.split(","));
				child.setImages(images);
				
				TbGroup group = tbGroupDubboServiceImpl.selById(item.getGroupId());
				child.setProvince(group.getProvince());
				child.setCity(group.getCity());
				
				childList.add(child);
			}
		}
		return JsonUtils.objectToJson(childList);
	}

}
