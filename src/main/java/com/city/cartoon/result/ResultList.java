package com.city.cartoon.result;

import java.util.List;

//封装列表方式，包括分页列表结果
public class ResultList<T> {
	private int page=0;//第几页
	private int pageCount=0;//页数
	private int rows=0;//每页行数
	private int count=0; //对象个数
	private List<T> list=null;
	private String status=null; //状态， OK正常，ERROR：异常
	private String message=null; //操作信息
	
	
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getPageCount() {
		return pageCount;
	}
	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}
	public int getRows() {
		return rows;
	}
	public void setRows(int rows) {
		this.rows = rows;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public List<T> getList() {
		return list;
	}
	public void setList(List<T> list) {
		this.list = list;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	
}
