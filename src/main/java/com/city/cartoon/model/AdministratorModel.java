package com.city.cartoon.model;

import org.apache.ibatis.type.Alias;

/*
 * 管理员Model类
*/
@Alias("Administrator")
public class AdministratorModel {
	
	
	private Integer adminid=0;
	private String adminpassword=null;

	
	public Integer getAdminid() {
		return adminid;
	}

	public void setAdminid(Integer adminid) {
		this.adminid = adminid;
	}

	public String getAdminpassword() {
		return adminpassword;
	}

	public void setAdminpassword(String adminpassword) {
		this.adminpassword = adminpassword;
	}
	
	

}
