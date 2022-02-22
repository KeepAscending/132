package com.lvg.dubbo.service;

import java.util.List;

import com.lvg.pojo.TbAdvert;

public interface TbAdvertDubboService {
	/**
	 * 获取最新的 count 个广告
	 * @param count
	 * @param isSort 是否排序
	 * @return
	 */
	List<TbAdvert> selByCount(int count, boolean isSort);

}
