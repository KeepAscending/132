package com.lvg.dubbo.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lvg.commons.pojo.WxDataGrid;
import com.lvg.dubbo.service.TbOrderDubboService;
import com.lvg.mapper.TbOrderMapper;
import com.lvg.pojo.TbOrder;
import com.lvg.pojo.TbOrderExample;
import com.lvg.pojo.TbOrderExample.Criteria;

public class TbOrderDubboServiceImpl implements TbOrderDubboService {
	
	@Resource
	private TbOrderMapper tbOrderMapper;

	@Override
	public List<TbOrder> selByIid(long iid, boolean flag) throws ParseException {
		TbOrderExample example = new TbOrderExample();
		Criteria criteria = example.createCriteria().andItemIdEqualTo(iid);
		if(flag) {
			Date date = new Date();
			SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
			String dateStr = format.format(date);
			Date today = format.parse(dateStr);
			criteria.andOuttimeGreaterThan(today);
		}
		return tbOrderMapper.selectByExample(example);
	}

	@Override
	public int insTbOrder(TbOrder order) {
		return tbOrderMapper.insertSelective(order);
	}

	@Override
	public WxDataGrid selByUidAndStatus(boolean isLandlord, long uid, byte status, int page, int rows) {
		//设置分页条件,注意:必须在查询全部的上面,否则无效
		PageHelper.startPage(page, rows);
		//设置查询条件
		TbOrderExample example = new TbOrderExample();
		example.setOrderByClause("created DESC");
		List<TbOrder> list = new ArrayList<>();
		Criteria criteria = example.createCriteria();
		// 是房东还是房客
		if(!isLandlord) {
			criteria.andCusIdEqualTo(uid);
			if(status!=0) {
				criteria.andStatusEqualTo(status);
			}
		}else {
			criteria.andHostIdEqualTo(uid);
			if(status==0) {
				criteria.andStatusEqualTo((byte) 1);
				Criteria criteria2 = example.createCriteria();
				criteria2.andHostIdEqualTo(uid);
				criteria2.andStatusEqualTo((byte) 3);
				Criteria criteria3 = example.createCriteria();
				criteria3.andHostIdEqualTo(uid);
				criteria3.andStatusEqualTo((byte) 4);
				example.or(criteria2);
				example.or(criteria3);
				
			}else {
				criteria.andStatusEqualTo(status);
			}
		}
		list = tbOrderMapper.selectByExample(example);
	
		//分页代码
		PageInfo<TbOrder> pi = new PageInfo<>(list);
		//放入到实体类
		WxDataGrid datagrid = new WxDataGrid();
		datagrid.setRows(pi.getList());
		long total = pi.getTotal();
		datagrid.setTotal(total);
		datagrid.setHasMore(true);
		long totalPages = (total%rows==0?total/rows:total/rows+1);
		if(page>=totalPages) {
			datagrid.setHasMore(false);
		}
		return datagrid;
	}

	@Override
	public int updTbOrder(TbOrder order) {
		return tbOrderMapper.updateByPrimaryKeySelective(order);
	}
}
