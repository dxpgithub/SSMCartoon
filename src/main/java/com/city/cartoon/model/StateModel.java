package com.city.cartoon.model;

import java.util.List;

import org.apache.ibatis.type.Alias;


/*
 * 漫画状态Model类

*/
@Alias("State")
public class StateModel {
	private Integer stateid=null;
	private String sname=null;
	private List<CartoonModel>  cartoons=null;
	
	public Integer getStateid() {
		return stateid;
	}
	public void setStateid(Integer stateid) {
		this.stateid = stateid;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public List<CartoonModel> getCartoons() {
		return cartoons;
	}
	public void setCartoons(List<CartoonModel> cartoons) {
		this.cartoons = cartoons;
	}
	

	
	
	
	
	
			
}
