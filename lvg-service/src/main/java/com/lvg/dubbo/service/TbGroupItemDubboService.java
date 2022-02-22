package com.lvg.dubbo.service;

import java.util.List;

import com.lvg.commons.pojo.WxDataGrid;
import com.lvg.pojo.TbGroupItem;

public interface TbGroupItemDubboService {
	/**
	 *  房型分页查询
	 * @param page 页
	 * @param rows 一页显示多少条数据
	 * @return
	 */
	WxDataGrid show(int page, int rows);
	
	/**
	 * 通过状态查询全部房型
	 * @param status
	 * @return
	 */
	List<TbGroupItem> selAllByStatus(byte status);
	
	/**
	 * 根据 id 查询房型
	 * @param id
	 * @return
	 */
	TbGroupItem selById(long id);
	
	/**
	 * 新增房型
	 * @param item
	 * @return
	 */
	int insTbGroupItem(TbGroupItem item);
	
	/**
	 * 根据房源id查询房型
	 * @param gid
	 * @return
	 */
	List<TbGroupItem> selByGroupId(long gid);
	
	/**
	 * 更新房型
	 * @param item
	 * @return
	 */
	int updTbGroupItem(TbGroupItem item);

}
