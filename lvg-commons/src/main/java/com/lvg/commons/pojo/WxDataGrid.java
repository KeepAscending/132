package com.lvg.commons.pojo;

import java.io.Serializable;
import java.util.List;

public class WxDataGrid implements Serializable {
	
	private int status;
	// 当前页面显示数据
	private List<?> rows;
	// 总条数
	private long total;
	// 是否还有数据
	private boolean hasMore;
	
	
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public List<?> getRows() {
		return rows;
	}
	public void setRows(List<?> rows) {
		this.rows = rows;
	}
	public long getTotal() {
		return total;
	}
	public void setTotal(long total) {
		this.total = total;
	}
	public boolean isHasMore() {
		return hasMore;
	}
	public void setHasMore(boolean hasMore) {
		this.hasMore = hasMore;
	}

}
