package com.lvg.order.service.impl;

import java.util.Date;

import org.springframework.stereotype.Service;

import com.alibaba.dubbo.config.annotation.Reference;
import com.lvg.commons.pojo.LvgResult;
import com.lvg.commons.utils.IDUtils;
import com.lvg.commons.utils.JsonUtils;
import com.lvg.dubbo.service.TbOrderEvalDubboService;
import com.lvg.order.service.TbOrderEvalService;
import com.lvg.pojo.TbOrderEval;

@Service
public class TbOrderEvalServiceImpl implements TbOrderEvalService {
	@Reference
	private TbOrderEvalDubboService tbOrderEvalDubboService;

	@Override
	public LvgResult addEval(String evalJson) {
		TbOrderEval eval = JsonUtils.jsonToPojo(evalJson, TbOrderEval.class);
		eval.setId(IDUtils.genItemId());
		eval.setCreated(new Date());
		int flag = tbOrderEvalDubboService.insTbOrderEval(eval);
		LvgResult result = new LvgResult();
		if(flag==1) {
			result.setStatus(200);
		}
		return result;
	}

}
