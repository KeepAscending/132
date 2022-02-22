package com.lvg.dubbo.service.impl;

import java.util.List;

import javax.annotation.Resource;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lvg.dubbo.service.TbAdvertDubboService;
import com.lvg.mapper.TbAdvertMapper;
import com.lvg.pojo.TbAdvert;
import com.lvg.pojo.TbAdvertExample;

public class TbAdvertDubboServiceImpl implements TbAdvertDubboService{
	
	@Resource
	private TbAdvertMapper tbAdvertMapper;

	@Override
	public List<TbAdvert> selByCount(int count, boolean isSort) {
		TbAdvertExample example = new TbAdvertExample();
		if(isSort) {
			example.setOrderByClause("updated desc");
		}
		if(count!=0) {
			PageHelper.startPage(1, count);
			List<TbAdvert> list = tbAdvertMapper.selectByExample(example);
			PageInfo<TbAdvert> pi = new PageInfo<>(list);
			return pi.getList();
		}else {
			return tbAdvertMapper.selectByExample(example);
		}
	}

}
