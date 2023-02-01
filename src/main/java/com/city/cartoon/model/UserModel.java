package com.city.cartoon.model;

import java.io.Serializable;
import java.util.List;
import org.apache.ibatis.type.Alias;

import com.fasterxml.jackson.annotation.JsonIgnore;



@Alias("USer")
public class UserModel implements Serializable{
	
	private Integer userid=0;//用户编号
	private String userpassword=null;//用户密码
	private String username=null;//用户昵称
	
	
	private byte[] photo=null; //员工照片
	private String filename=null; //照片文件名
	private String contenttype=null; //照片文件类型
	
	private List<CartoonModel> cartoons=null;
	private List<CategoryModel> categorys=null;
	
	public Integer getUserid() {
		return userid;
	}
	public void setUserid(Integer userid) {
		this.userid = userid;
	}
	
	public String getUserpassword() {
		return userpassword;
	}
	public void setUserpassword(String userpassword) {
		this.userpassword = userpassword;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public byte[] getPhoto() {
		return photo;
	}
	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}
	
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	public String getContenttype() {
		return contenttype;
	}
	public void setContenttype(String contenttype) {
		this.contenttype = contenttype;
	}
	public List<CartoonModel> getCartoons() {
		return cartoons;
	}
	public void setCartoons(List<CartoonModel> cartoons) {
		this.cartoons = cartoons;
	}
	public List<CategoryModel> getCategorys() {
		return categorys;
	}
	public void setCategorys(List<CategoryModel> categorys) {
		this.categorys = categorys;
	}
	
	
	
}
