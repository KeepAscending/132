package com.lvg.collect.service;

public interface TbUserService {
	/**
	 * 收藏或取消收藏
	 * @param uid
	 * @param iid
	 * @param collect
	 * @return
	 */
	int changeCollect(long uid, long iid, boolean collect);
}
