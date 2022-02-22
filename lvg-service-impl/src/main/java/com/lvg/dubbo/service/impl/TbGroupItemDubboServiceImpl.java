package com.lvg.dubbo.service.impl;

import java.util.List;

import javax.annotation.Resource;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lvg.commons.pojo.WxDataGrid;
import com.lvg.dubbo.service.TbGroupItemDubboService;
import com.lvg.mapper.TbGroupItemMapper;
import com.lvg.pojo.TbGroupItem;
import com.lvg.pojo.TbGroupItemExample;

public class TbGroupItemDubboServiceImpl implements TbGroupItemDubboService{
	@Resource
	private TbGroupItemMapper tbGroupItemMapper;

	@Override
	public WxDataGrid show(int page, int rows) {
		//设置分页条件,注意:必须在查询全部的上面,否则无效
		PageHelper.startPage(page, rows);
		//查询全部
		List<TbGroupItem> list = tbGroupItemMapper.selectByExample(new TbGroupItemExample());
		//分页代码
		PageInfo<TbGroupItem> pi = new PageInfo<>(list);
		//放入到实体类
		WxDataGrid datagrid = new WxDataGrid();
		datagrid.setRows(pi.getList());
		datagrid.setTotal(pi.getTotal());
		
		return datagrid;
	}

	@Override
	public List<TbGroupItem> selAllByStatus(byte status) {
		TbGroupItemExample example = new TbGroupItemExample();
		example.createCriteria().andStatusEqualTo(status);
		return tbGroupItemMapper.selectByExample(example);
	}

	@Override
	public TbGroupItem selById(long id) {
		return tbGroupItemMapper.selectByPrimaryKey(id);
	}

	@Override
	public int insTbGroupItem(TbGroupItem item) {
		return tbGroupItemMapper.insertSelective(item);
	}

	@Override
	public List<TbGroupItem> selByGroupId(long gid) {
		TbGroupItemExample example = new TbGroupItemExample();
		example.setOrderByClause("created DESC");
		example.createCriteria().andGroupIdEqualTo(gid);
		return tbGroupItemMapper.selectByExample(example);
	}

	@Override
	public int updTbGroupItem(TbGroupItem item) {
		return tbGroupItemMapper.updateByPrimaryKeySelective(item);
	}
	
	

}
