package com.lvg.manage.service;

import com.lvg.commons.pojo.WxDataGrid;

public interface TbGroupItemService {
	/**
	 * 显示型列表
	 * @param page
	 * @param rows
	 * @return
	 */
	WxDataGrid show(int page, int rows);

}
