package com.lvg.item.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lvg.commons.pojo.LvgResult;
import com.lvg.commons.pojo.WxDataGrid;
import com.lvg.item.service.TbGroupService;

@Controller
public class TbGroupController {
	@Resource
	private TbGroupService tbGroupServiceImpl;
	
	/**
	 * 新增房源
	 * @param groupJson
	 * @return
	 */
	@RequestMapping(value = "group/add", produces="application/json;charset=utf-8")
	@ResponseBody
	public LvgResult addGroup(String groupJson) {
		return tbGroupServiceImpl.addGroup(groupJson);
	}
	
	/**
	 * 根据房东id获取房源
	 * @param uid
	 * @return
	 */
	@RequestMapping(value = "group/list", produces="application/json;charset=utf-8")
	@ResponseBody
	public WxDataGrid showList(long uid) {
		return tbGroupServiceImpl.getList(uid);
	}
	
	/**
	 * 更新房源
	 * @param groupJson
	 * @return
	 */
	@RequestMapping(value = "group/update", produces="application/json;charset=utf-8")
	@ResponseBody
	public LvgResult updGroup(String groupJson) {
		return tbGroupServiceImpl.updGroup(groupJson);
	}
	
}
