package com.lvg.order.service;

import java.text.ParseException;

import com.lvg.commons.pojo.LvgResult;
import com.lvg.commons.pojo.WxDataGrid;

public interface TbOrderService {
	/**
	 * 根据房型id获取已预订日期
	 * @param iid
	 * @return
	 * @throws ParseException 
	 */
	String getBookdate(long iid) throws ParseException;
	
	/**
	 * 预订
	 * @param order
	 * @return
	 */
	LvgResult onBook(String order, String intime, String outtime) throws ParseException;
	
	/**
	 * 根据 user_id 和 订单状态获取订单
	 * @param isLandlord 是否为房东
	 * @param uid
	 * @param status 为0时查询所有订单（房客身份是所有状态的订单12345，房东身份是有效订单1、已完成订单3和房客已取消订单4）
	 * @param page
	 * @param rows
	 * @param hasMore
	 * @return
	 */
	WxDataGrid showList(boolean isLandlord, long uid, byte status, int page, int rows);
	
	/**
	 * 更新订单
	 * @param oid
	 */
	LvgResult updTbOrder(String orderJson);
}
