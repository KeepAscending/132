package com.lvg.collect.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lvg.collect.service.TbGroupItemService;

@Controller
public class TbGroupItemController {
	@Resource
	private TbGroupItemService tbGroupItemServiceImpl;
	
	/**
	 * 获取收藏列表
	 * @param uid
	 * @return
	 */
	@RequestMapping(value = "collect/list", produces = "application/xml;charset=utf-8")
	@ResponseBody
	public String getCollectList(long uid) {
		return tbGroupItemServiceImpl.getCollectList(uid);
	}

}
