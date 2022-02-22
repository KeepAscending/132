package com.lvg.manage.service.impl;

import java.io.IOException;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.lvg.commons.pojo.LvgResult;
import com.lvg.commons.utils.FtpUtil;
import com.lvg.manage.service.MediaService;

@Service
public class MediaServiceImpl implements MediaService {
	@Value("${ftpclient.host}")
	private String host;
	
	@Value("${ftpclient.port}")
	private int port;
	
	@Value("${ftpclient.username}")
	private String username;
	
	@Value("${ftpclient.password}")
	private String password;
	
	@Value("${ftpclient.basePath}")
	private String basePath;
	
	@Value("${ftpclient.filePath}")
	private String filePath;

	@Override
	public LvgResult upload(MultipartFile file) {
		LvgResult lvgResult = new LvgResult();
		String fileName = file.getOriginalFilename();
		String newName = UUID.randomUUID().toString() + fileName.substring(fileName.lastIndexOf("."));
		boolean result = false;
		try {
			result = FtpUtil.uploadFile(host, port, username, password, basePath, filePath, newName, file.getInputStream());
			if(result) {
				lvgResult.setStatus(200);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		lvgResult.setData(newName);
		return lvgResult;
	}

}
