package com.lvg.portal.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lvg.portal.service.TbAdvertService;

@Controller
public class TbAdvertController {
	@Resource
	private TbAdvertService tbAdvertServiceImpl;
	
	@RequestMapping(value = "/advert/show", produces="application/xml;charset=utf-8")
	@ResponseBody
	public String showAdvert(@RequestParam(value = "count", defaultValue = "3") int count, @RequestParam(value="isSort", defaultValue = "true") boolean isSort) {
		return tbAdvertServiceImpl.showAdvert(count, isSort);
	}

}
