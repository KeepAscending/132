package com.lvg.dubbo.service;

import java.text.ParseException;
import java.util.List;

import com.lvg.commons.pojo.WxDataGrid;
import com.lvg.pojo.TbOrder;


public interface TbOrderDubboService {
	/**
	 * 根据房型 id 查询订单
	 * @param iid
	 * @param flag 为 true 时新增时间条件查询
	 * @return
	 * @throws ParseException
	 */
	List<TbOrder> selByIid(long iid, boolean flag) throws ParseException;
	
	/**
	 * 新增订单
	 * @param order
	 * @return
	 */
	int insTbOrder(TbOrder order);
	
	/**
	 * 根据 user_id 和 订单状态分页查询
	 * @param isLandlord 是否为房东
	 * @param uid
	 * @param status 为0时查询所有订单（房客身份是所有状态的订单12345，房东身份是有效订单1、已完成订单3和房客已取消订单4）
	 * @param page
	 * @param rows
	 * @return
	 */
	WxDataGrid selByUidAndStatus(boolean isLandlord, long uid, byte status, int page, int rows);
	
	/**
	 * 更新订单信息
	 * @param order
	 * @return
	 */
	int updTbOrder(TbOrder order);
	
}
