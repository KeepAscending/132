package com.lvg.item.service;

import com.lvg.commons.pojo.LvgResult;
import com.lvg.commons.pojo.WxDataGrid;

public interface TbGroupItemService {
	/**
	 * 获取房型详情
	 * @param uid
	 * @param iid
	 * @return
	 */
	String getItemDetail(long uid, long iid);
	
	/**
	 * 新增房型
	 * @param itemJson
	 * @return
	 */
	LvgResult addItem(String itemJson);
	
	/**
	 * 根据房源id获取房型
	 * @param gid
	 * @return
	 */
	WxDataGrid getList(long gid);
	
	/**
	 * 更新房型
	 * @param itemJson
	 * @return
	 */
	LvgResult updItem(String itemJson);
}
