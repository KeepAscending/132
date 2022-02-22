package com.lvg.dubbo.service.impl;

import java.util.List;

import javax.annotation.Resource;

import com.lvg.dubbo.service.TbGroupDubboService;
import com.lvg.mapper.TbGroupMapper;
import com.lvg.pojo.TbGroup;
import com.lvg.pojo.TbGroupExample;

public class TbGroupDubboServiceImpl implements TbGroupDubboService {
	@Resource
	private TbGroupMapper tbGroupMapper;

	@Override
	public TbGroup selById(long id) {
		return tbGroupMapper.selectByPrimaryKey(id);
	}

	@Override
	public int insTbGroup(TbGroup group) {
		return tbGroupMapper.insertSelective(group);
	}

	@Override
	public List<TbGroup> selByUid(long uid) {
		TbGroupExample example = new TbGroupExample();
		example.setOrderByClause("created DESC");
		example.createCriteria().andHostIdEqualTo(uid);
		return tbGroupMapper.selectByExample(example);
	}

	@Override
	public int updTbGroup(TbGroup group) {
		return tbGroupMapper.updateByPrimaryKeySelective(group);
	}

}
