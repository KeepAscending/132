package com.lvg.search.controller;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.solr.client.solrj.SolrServerException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lvg.commons.pojo.WxDataGrid;
import com.lvg.commons.utils.JsonUtils;
import com.lvg.pojo.TbGroupItem;
import com.lvg.search.service.TbGroupItemService;

@Controller
public class TbGroupItemController {
	
	@Resource
	private TbGroupItemService tbGroupItemServiceImpl;
	
	/**
	 * 初始化
	 * @return
	 */
	@RequestMapping(value = "solr/init", produces = "text/html;charset=utf-8")
	@ResponseBody
	public String init() {
		long start = System.currentTimeMillis();
		try {
			tbGroupItemServiceImpl.init();
			long end = System.currentTimeMillis();
			return "初始化总时间:"+(end-start)/1000+"秒";
		} catch (SolrServerException | IOException e) {
			e.printStackTrace();
			return "初始化失败";
		}
	}
	
	/**
	 * 搜索功能
	 * @param uid
	 * @param query
	 * @param page
	 * @param rows
	 * @param hasMore
	 * @return
	 */
	@RequestMapping(value = "search", produces="application/xml;charset=utf-8")
	@ResponseBody
	public String search(@RequestParam(defaultValue = "0")long uid, 
			@RequestParam(defaultValue = "")String query,
			@RequestParam(defaultValue = "")String intime,
			@RequestParam(defaultValue = "")String outtime,
			@RequestParam(defaultValue = "1") int page, 
			@RequestParam(defaultValue = "10") int rows, 
			@RequestParam(defaultValue = "true") boolean hasMore) {
		WxDataGrid dataGrid = new WxDataGrid();
		try {
			dataGrid = tbGroupItemServiceImpl.search(uid, query, intime, outtime, page, rows, hasMore);
		} catch (SolrServerException | IOException e) {
			e.printStackTrace();
		}
		return JsonUtils.objectToJson(dataGrid);
	}
	
	/**
	 * 新增或修改
	 * @param map
	 * @return
	 */
	@RequestMapping("solr/addOrUpd")
	@ResponseBody//把程序返回对象转换成Json数据设置到响应体中
	public int addOrUpd(@RequestBody Map<String, TbGroupItem> map){// @RequestBody:把请求体中的Json数据转换成指定对象
		try {
			return tbGroupItemServiceImpl.addOrUpd(map);
		} catch (SolrServerException | IOException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	/**
	 * 删除下架
	 * @param iid
	 */
	@RequestMapping("solr/delete")
	@ResponseBody
	public void delete(String iid) {
		try {
			tbGroupItemServiceImpl.delete(iid);
		} catch (SolrServerException | IOException e) {
			e.printStackTrace();
		}
	}
}
