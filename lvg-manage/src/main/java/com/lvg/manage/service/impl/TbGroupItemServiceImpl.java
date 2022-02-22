package com.lvg.manage.service.impl;

import org.springframework.stereotype.Service;

import com.alibaba.dubbo.config.annotation.Reference;
import com.lvg.commons.pojo.WxDataGrid;
import com.lvg.dubbo.service.TbGroupItemDubboService;
import com.lvg.manage.service.TbGroupItemService;

@Service
public class TbGroupItemServiceImpl implements TbGroupItemService{
	@Reference
	private TbGroupItemDubboService tbGroupItemDubboServiceImpl;

	@Override
	public WxDataGrid show(int page, int rows) {
		// TODO Auto-generated method stub
		return tbGroupItemDubboServiceImpl.show(page, rows);
	}

}
