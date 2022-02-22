package com.lvg.dubbo.service.impl;

import java.util.List;

import javax.annotation.Resource;

import com.lvg.dubbo.service.TbUserDubboService;
import com.lvg.mapper.TbUserMapper;
import com.lvg.pojo.TbUser;
import com.lvg.pojo.TbUserExample;

public class TbUserDubboServiceImpl implements TbUserDubboService{
	
	@Resource
	private TbUserMapper tbUserMapper;

	@Override
	public List<TbUser> selByOpenid(String openid) {
		TbUserExample example = new TbUserExample();
		example.createCriteria().andOpenidEqualTo(openid);
		List<TbUser> list = tbUserMapper.selectByExample(example);
		return list;
	}

	@Override
	public int insTbUser(TbUser user) {
		return tbUserMapper.insert(user);
	}

	@Override
	public TbUser selById(long id) {
		return tbUserMapper.selectByPrimaryKey(id);
	}

	@Override
	public int updTbUser(TbUser user) {
		return tbUserMapper.updateByPrimaryKeySelective(user);
	}

}
