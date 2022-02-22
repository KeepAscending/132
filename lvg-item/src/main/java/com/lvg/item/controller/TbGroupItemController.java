package com.lvg.item.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lvg.commons.pojo.LvgResult;
import com.lvg.commons.pojo.WxDataGrid;
import com.lvg.item.service.TbGroupItemService;

@Controller
public class TbGroupItemController {
	@Resource
	private TbGroupItemService tbGroupItemServiceImpl;
	
	/**
	 * 获取房型详情信息
	 * @param uid
	 * @param iid
	 * @return
	 */
	@RequestMapping(value = "item/detail", produces="application/xml;charset=utf-8")
	@ResponseBody
	public String getDetail(long uid, long iid) {
		return tbGroupItemServiceImpl.getItemDetail(uid, iid);
	}
	
	/**
	 * 新增房型
	 * @param ItemJson
	 * @return
	 */
	@RequestMapping(value = "item/add", produces="application/json;charset=utf-8")
	@ResponseBody
	public LvgResult addItem(String itemJson) {
		return tbGroupItemServiceImpl.addItem(itemJson);
	}
	
	/**
	 * 根据房源id获取房型
	 * @param gid
	 * @return
	 */
	@RequestMapping(value = "item/list", produces="application/json;charset=utf-8")
	@ResponseBody
	public WxDataGrid showList(long gid) {
		return tbGroupItemServiceImpl.getList(gid);
	} 
	
	/**
	 * 更新房型信息
	 * @param itemJson
	 * @return
	 */
	@RequestMapping(value = "item/update", produces="application/json;charset=utf-8")
	@ResponseBody
	public LvgResult updItem(String itemJson) {
		return tbGroupItemServiceImpl.updItem(itemJson);
	}
}
