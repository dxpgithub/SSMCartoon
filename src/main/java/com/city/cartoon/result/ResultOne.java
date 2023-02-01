package com.city.cartoon.result;

//返回单个数据或对象的结果
public class ResultOne<T> {
	private T result=null;
	private String status=null;
	private String message=null;
	
	public T getResult() {
		return result;
	}
	public void setResult(T result) {
		this.result = result;
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
