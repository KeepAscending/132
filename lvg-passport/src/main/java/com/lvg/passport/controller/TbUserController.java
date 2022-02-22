package com.lvg.passport.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lvg.commons.pojo.LvgResult;
import com.lvg.passport.service.TbUserService;

@Controller
public class TbUserController {
	@Resource
	private TbUserService tbUserServiceImpl;
	
	/**
	 * 微信登录
	 * @param code res.code
	 * @param nickname 微信名称
	 * @param headpic 微信头像
	 * @return
	 */
	@RequestMapping(value="user/wxlogin", produces="application/json;charset=UTF-8")
	@ResponseBody
	public LvgResult wxLogin(@RequestParam("code") String code, 
			@RequestParam("nickname") String nickname,  
			@RequestParam("headpic") String headpic) {
		return tbUserServiceImpl.wxLogin(code, nickname, headpic);
	}  

}
