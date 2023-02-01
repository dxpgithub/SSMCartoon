package com.city.cartoon.model;

import java.util.List;

import org.apache.ibatis.type.Alias;


/*
 * 题材类别Model类
 */
@Alias("Category")
public class CategoryModel {
	
	
	private Integer categoryno=0;
	private String cname=null;
	private List<CartoonModel>  cartoons=null;
	
	private List<UserModel> users=null; 
	
	public List<UserModel> getUsers() {
		return users;
	}

	public void setUsers(List<UserModel> users) {
		this.users = users;
	}

	public List<CartoonModel> getCartoons() {
		return cartoons;
	}

	public void setCartoons(List<CartoonModel> cartoons) {
		this.cartoons = cartoons;
	}

	public Integer getCategoryno() {
		return categoryno;
	}

	public void setCategoryno(Integer categoryno) {
		this.categoryno = categoryno;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	
	
	
	

}
