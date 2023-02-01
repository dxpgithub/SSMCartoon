package com.city.cartoon.model;

import java.util.List;
import org.apache.ibatis.type.Alias;

/*
 * 出版社Model类
 
*/
@Alias("Publisher")
public class PublisherModel {
	
	private Integer publisherid=0;
	private String publishername=null;
	
	/*
	 * 出版社和漫画为一对多关联,被动方
	 */
	private List<CartoonModel>  cartoons=null;
	
	public Integer getPublisherid() {
		return publisherid;
	}

	public void setPublisherid(Integer publisherid) {
		this.publisherid = publisherid;
	}

	public String getPublishername() {
		return publishername;
	}

	public void setPublishername(String publishername) {
		this.publishername = publishername;
	}
	
	
	
	
	
	
	
}
