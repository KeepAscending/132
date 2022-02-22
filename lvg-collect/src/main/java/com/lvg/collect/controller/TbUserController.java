package com.lvg.collect.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lvg.collect.service.TbUserService;


@Controller
public class TbUserController {
	@Resource
	private TbUserService tbUserServiceImpl;
	
	/**
	 * 更新收藏
	 * @param uid
	 * @param iid
	 * @param collect
	 * @return
	 */
	@RequestMapping(value = "collect", produces="application/xml;charset=utf-8")
	@ResponseBody
	public void changeCollect(long uid, long iid, boolean collect) {
		tbUserServiceImpl.changeCollect(uid, iid, collect);
	}

}
