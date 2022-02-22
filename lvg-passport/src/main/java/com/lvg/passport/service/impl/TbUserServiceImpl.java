package com.lvg.passport.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.alibaba.dubbo.config.annotation.Reference;
import com.lvg.commons.pojo.LvgResult;
import com.lvg.commons.utils.HttpClientUtil;
import com.lvg.commons.utils.IDUtils;
import com.lvg.commons.utils.JsonUtils;
import com.lvg.dubbo.service.TbUserDubboService;
import com.lvg.passport.pojo.OpenId;
import com.lvg.passport.service.TbUserService;
import com.lvg.pojo.TbUser;

@Service
public class TbUserServiceImpl implements TbUserService{
	@Reference
	private TbUserDubboService tbUserDubboServiceImpl;

    @Value("${wx.appid}")
	private String appid;
	@Value("${wx.appsecret}")
	private String appsecret;

	@Override
	public LvgResult wxLogin(String code, String nickname, String headpic) {
		LvgResult result = new LvgResult();
		
		String url = "https://api.weixin.qq.com/sns/jscode2session?appid=" + appid
				+ "&secret="+ appsecret 
				+ "&js_code="+ code 
				+ "&grant_type=authorization_code";
		 
		String jsonUser = HttpClientUtil.doPost(url);
		OpenId open = JsonUtils.jsonToPojo(jsonUser, OpenId.class);
		System.out.println("jsonUser:"+jsonUser.toString());
		String openid = open.getOpenid();
		TbUser user = new TbUser();
		if(openid!="" && openid!=null) {
			List<TbUser> list = tbUserDubboServiceImpl.selByOpenid(openid);
			if(list.size()==0) {
				long id = IDUtils.genItemId();
				user.setId(id);
				user.setOpenid(openid);
				user.setNickname(nickname);
				user.setImage(headpic);
			    Date date = new Date();
				user.setCreated(date);
				user.setUpdated(date);
				tbUserDubboServiceImpl.insTbUser(user);
			}else {
				user = list.get(0);
			}
			result.setData(user);
			result.setStatus(200);
		}
		return result;
	}

}
