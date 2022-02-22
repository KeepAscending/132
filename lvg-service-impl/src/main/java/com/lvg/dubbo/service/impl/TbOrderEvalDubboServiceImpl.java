package com.lvg.dubbo.service.impl;

import javax.annotation.Resource;

import com.lvg.dubbo.service.TbOrderEvalDubboService;
import com.lvg.mapper.TbOrderEvalMapper;
import com.lvg.pojo.TbOrderEval;

public class TbOrderEvalDubboServiceImpl implements TbOrderEvalDubboService {

	@Resource
	private TbOrderEvalMapper tbOrderEvalMapper;

	@Override
	public int insTbOrderEval(TbOrderEval eval) {
		return tbOrderEvalMapper.insert(eval);
	}

}
