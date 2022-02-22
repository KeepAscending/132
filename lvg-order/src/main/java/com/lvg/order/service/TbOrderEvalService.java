package com.lvg.order.service;

import com.lvg.commons.pojo.LvgResult;

public interface TbOrderEvalService {

	/**
	 * 新增订单评价
	 * @param evalJson
	 * @return
	 */
	LvgResult addEval(String evalJson);
}
