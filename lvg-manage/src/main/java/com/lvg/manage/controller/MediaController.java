package com.lvg.manage.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.lvg.commons.pojo.LvgResult;
import com.lvg.manage.service.MediaService;

@Controller
public class MediaController {
	@Resource
	private MediaService mediaServiceImpl;
	
	@RequestMapping(value = "/upload", produces = "application/json;charset=utf-8")
	@ResponseBody
	public LvgResult upload(MultipartFile file) {
		return mediaServiceImpl.upload(file);
	}

}
