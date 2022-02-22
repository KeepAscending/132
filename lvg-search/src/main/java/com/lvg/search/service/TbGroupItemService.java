package com.lvg.search.service;

import java.io.IOException;
import java.util.Map;

import org.apache.solr.client.solrj.SolrServerException;

import com.lvg.commons.pojo.WxDataGrid;
import com.lvg.pojo.TbGroupItem;

public interface TbGroupItemService {
	/**
	 * 初始化 solr
	 * @throws SolrServerException
	 * @throws IOException
	 */
	void init() throws SolrServerException, IOException;
	
	/**
	 * 通过关键字分页搜索
	 * @param query
	 * @param page
	 * @param rows
	 * @param hasMore
	 * @return
	 * @throws SolrServerException
	 * @throws IOException
	 */
	WxDataGrid search(long uid, String query, String intime, String outtime, int page, int rows, boolean hasMore) throws SolrServerException, IOException;

	/**
	 * 新增或修改
	 * @param map
	 * @return
	 * @throws SolrServerException
	 * @throws IOException
	 */
	int addOrUpd(Map<String, TbGroupItem> map) throws SolrServerException, IOException;
	
	/**
	 * 根据item_id删除
	 * @param iid
	 * @throws SolrServerException
	 * @throws IOException
	 */
	void delete(String iid) throws SolrServerException, IOException;
}
