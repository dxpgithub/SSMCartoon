package com.city.cartoon.mapper;

import java.util.List;

import com.city.cartoon.model.CategoryModel;
import com.city.cartoon.model.PublisherModel;

public interface IPublisherMapper {
	public List<PublisherModel>  selectAll()throws Exception;
	
	
	public void Insert(PublisherModel pm)throws Exception; 
	
	public void Update(PublisherModel pm)throws Exception; 
	
	public void Delete(PublisherModel pm)throws Exception; 
}
