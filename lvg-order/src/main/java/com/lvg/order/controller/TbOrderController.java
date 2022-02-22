package com.lvg.order.controller;

import java.text.ParseException;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lvg.commons.pojo.LvgResult;
import com.lvg.commons.pojo.WxDataGrid;
import com.lvg.order.service.TbOrderService;

@Controller
public class TbOrderController {
	
	@Resource
	private TbOrderService tbOrderServiceImpl;
	
	/**
	 * 根据房型id获取已预订日期
	 * @param iid
	 * @return
	 */
	@RequestMapping(value = "order/bookdate", produces="application/xml;charset=utf-8")
	@ResponseBody
	public String getBookdate(long iid) {
		String bookdate = null;
		try {
			bookdate = tbOrderServiceImpl.getBookdate(iid);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		System.out.println(bookdate);
		return bookdate;
	}
	
	/**
	 * 预订，新增订单
	 * @param order
	 * @param intime
	 * @param outtime
	 * @return
	 */
	@RequestMapping(value = "order", produces="application/json;charset=utf-8")
	@ResponseBody
	public LvgResult onBook(String order, String intime, String outtime) {
		LvgResult result = new LvgResult();
		try {
			result = tbOrderServiceImpl.onBook(order, intime, outtime);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	/**
	 * 获取旅客模式下订单列表及详情
	 * @param isLandlord 是否为房东
	 * @param uid user_id
	 * @param status 订单状态
	 * @param page
	 * @param rows
	 * @return
	 */
	@RequestMapping(value = "order/list", produces="application/json;charset=utf-8")
	@ResponseBody
	public WxDataGrid showList(boolean isLandlord, 
			@RequestParam(defaultValue = "0")long uid, 
			@RequestParam(defaultValue = "0") byte status, 
			@RequestParam(defaultValue = "1") int page, 
			@RequestParam(defaultValue = "10") int rows) {
		WxDataGrid dataGrid = tbOrderServiceImpl.showList(isLandlord, uid, status, page, rows);
		return dataGrid;
	}
	
	/**
	 * 更新订单
	 * @param orderJson
	 */
	@RequestMapping(value = "order/update", produces="application/json;charset=utf-8")
	@ResponseBody
	public LvgResult updTbOrder(String orderJson) {
		return tbOrderServiceImpl.updTbOrder(orderJson);
	}
	
	
}
