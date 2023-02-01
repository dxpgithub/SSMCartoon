package com.city.cartoon.model;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.type.Alias;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
@Alias("Cartoon")
public class CartoonModel {
	private Integer cartoonid=0;
	private String cartoonname=null;
	private String author=null;//漫画作者
	private String description=null;//漫画描述
	
	@DateTimeFormat(pattern = "yyyy-mm-dd")
	@JsonFormat(pattern = "yyyy-mm-dd")
	private Date cartoondate;//出版日期
	
	@JsonIgnore
	private byte[] photo=null;//图片
	private String filename=null;//文件名
	private String contenttype=null;//文件类型
	
	
	//多对一关联关系
	
	private CategoryModel category=null; //关联的题材
	
	private PublisherModel publisher=null;//出版社
	
	private StateModel  state=null;
	
	//多对多关联
	private List<UserModel> users=null; 
	

	
	public Integer getCartoonid() {
		return cartoonid;
	}
	public void setCartoonid(Integer cartoonid) {
		this.cartoonid = cartoonid;
	}
	public String getCartoonname() {
		return cartoonname;
	}
	public void setCartoonname(String cartoonname) {
		this.cartoonname = cartoonname;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public Date getCartoondate() {
		return cartoondate;
	}
	public void setCartoondate(Date cartoondate) {
		this.cartoondate = cartoondate;
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
	public CategoryModel getCategory() {
		return category;
	}
	public void setCategory(CategoryModel category) {
		this.category = category;
	}
	public PublisherModel getPublisher() {
		return publisher;
	}
	public void setPublisher(PublisherModel publisher) {
		this.publisher = publisher;
	}
	public StateModel getState() {
		return state;
	}
	public void setState(StateModel state) {
		this.state = state;
	}
	public List<UserModel> getUsers() {
		return users;
	}
	public void setUsers(List<UserModel> users) {
		this.users = users;
	}
	
	
	
	
	
}









