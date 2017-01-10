package com.aiden.core.action;

import com.aiden.core.page.PageResult;
import com.opensymphony.xwork2.ActionSupport;

public class BaseAction extends ActionSupport {

	protected String[] selectedRow;
	public PageResult pageResult;
	private int pageNo;
	private int pageSize;
	//默认页大小
	public static int DEFAULT_PAGE_SIZE = 3;
	public String[] getSelectedRow() {
		return selectedRow;
	}

	public void setSelectedRow(String[] selectedRow) {
		this.selectedRow = selectedRow;
	}

	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public int getPageSize() {
		if(pageSize < 1) pageSize = DEFAULT_PAGE_SIZE;
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
}
