package com.lvg.dubbo.service;

import java.util.List;

import com.lvg.pojo.TbUser;

public interface TbUserDubboService {
	/**
	 * 根据 openid 查询用户信息
	 * @param user
	 * @return
	 */
	List<TbUser> selByOpenid(String openid);
	
	/**
	 * 新增用户
	 * @param user
	 * @return
	 */
	int insTbUser(TbUser user);
	
	/**
	 * 通过主键id查询用户
	 * @param id
	 * @return
	 */
	TbUser selById(long id);
	
	/**
	 * 更新用户信息
	 * @param user
	 * @return
	 */
	int updTbUser(TbUser user);

}
