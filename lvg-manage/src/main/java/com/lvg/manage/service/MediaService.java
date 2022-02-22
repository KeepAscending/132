package com.lvg.manage.service;

import org.springframework.web.multipart.MultipartFile;

import com.lvg.commons.pojo.LvgResult;

public interface MediaService {
	/**
	 * 文件上传
	 * @param filePath
	 * @param fileName
	 * @return
	 */
	LvgResult upload(MultipartFile file);
}
