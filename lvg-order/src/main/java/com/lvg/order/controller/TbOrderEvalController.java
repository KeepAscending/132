package com.lvg.order.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lvg.commons.pojo.LvgResult;
import com.lvg.order.service.TbOrderEvalService;

@Controller
public class TbOrderEvalController {
	
	@Resource
	private TbOrderEvalService tbOrderEvalServiceImpl;
	
	/**
	 * 新增订单评价
	 * @param evalJson
	 * @return
	 */
	@RequestMapping(value = "orderEval/add", produces="application/json;charset=utf-8")
	@ResponseBody
	public LvgResult addEval(String evalJson) {
		return tbOrderEvalServiceImpl.addEval(evalJson);
	}

}
