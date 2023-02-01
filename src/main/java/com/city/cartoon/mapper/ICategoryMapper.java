package com.city.cartoon.mapper;

import java.util.List;

import com.city.cartoon.model.CategoryModel;

public interface ICategoryMapper {
	public List<CategoryModel> selectAll() throws Exception; 
	
	public CategoryModel selectByNo(Integer no)throws Exception; 
	
	public void Insert(CategoryModel cm)throws Exception; 
	
	public void Update(CategoryModel cm)throws Exception; 
	
	public void Delete(CategoryModel cm)throws Exception; 
}
