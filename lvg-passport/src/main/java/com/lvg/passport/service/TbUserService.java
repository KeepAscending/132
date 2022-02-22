package com.lvg.passport.service;

import com.lvg.commons.pojo.LvgResult;

public interface TbUserService {
	/**
	 * 微信登陆
	 * @param code
	 * @return
	 */
	LvgResult wxLogin(String code, String nickname, String headpic);

}
