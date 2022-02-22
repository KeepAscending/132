package com.lvg.dubbo.service;

import java.util.List;

import com.lvg.pojo.TbGroup;

public interface TbGroupDubboService {
	
	/**
	 * 通过id查询
	 * @param id
	 * @return
	 */
	TbGroup selById(long id);
	
	/**
	 * 新增房源
	 * @param group
	 * @return
	 */
	int insTbGroup(TbGroup group);
	
	/**
	 * 根据房东id查询房源
	 * @param uid
	 * @return
	 */
	List<TbGroup> selByUid(long uid);
	
	
	/**
	 * 更新房源
	 * @param group
	 * @return
	 */
	int updTbGroup(TbGroup group);
}
