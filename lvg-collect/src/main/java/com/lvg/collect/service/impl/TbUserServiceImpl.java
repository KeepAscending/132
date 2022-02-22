package com.lvg.collect.service.impl;

import org.springframework.stereotype.Service;

import com.alibaba.dubbo.config.annotation.Reference;
import com.lvg.collect.service.TbUserService;
import com.lvg.dubbo.service.TbUserDubboService;
import com.lvg.pojo.TbUser;

@Service
public class TbUserServiceImpl implements TbUserService {
	@Reference
	private TbUserDubboService tbUserDubboServiceImpl;

	@Override
	public int changeCollect(long uid, long iid, boolean collect) {
		TbUser user = tbUserDubboServiceImpl.selById(uid);
		if(collect) {
			String coStr = user.getCollect()+iid+",";
			user.setCollect(coStr);
		} else {
			String[] coArr = user.getCollect().split(",");
			StringBuilder sb = new StringBuilder();
			for (String str : coArr) {
				if(!str.equals(""+iid)) {
					sb.append(str+",");
				}
			}
			user.setCollect(sb.toString());
		}
		System.out.println(user.getCollect());
		return tbUserDubboServiceImpl.updTbUser(user);
	}

}
