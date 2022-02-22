package com.lvg.manage.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lvg.commons.pojo.WxDataGrid;
import com.lvg.manage.service.TbGroupItemService;

@Controller
public class TbGroupItemController {
	@Resource
	private TbGroupItemService tbGroupItemServiceImpl;
	
	/**
	 * 微信登陆
	 * @param page
	 * @param rows
	 * @return
	 */
	@RequestMapping("groupitem/list")
	@ResponseBody
	public WxDataGrid show(int page, int rows) {
		return tbGroupItemServiceImpl.show(page, rows);
	}

}
