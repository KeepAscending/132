package com.lvg.item.service;

import com.lvg.commons.pojo.LvgResult;
import com.lvg.commons.pojo.WxDataGrid;

public interface TbGroupService {
	/**
	 * 新增房源
	 * @param groupJson
	 * @return
	 */
	LvgResult addGroup(String groupJson);
	
	/**
	 * 根据房东id获取房源列表
	 * @param uid
	 * @return
	 */
	WxDataGrid getList(long uid);
	
	/**
	 * 更新房源
	 * @param groupJson
	 * @return
	 */
	LvgResult updGroup(String groupJson);
}
