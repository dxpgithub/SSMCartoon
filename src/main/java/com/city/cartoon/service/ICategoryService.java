package com.city.cartoon.service;

import java.util.List;

import com.city.cartoon.model.CategoryModel;

public interface ICategoryService {

	
	
	//取得全部漫画
	public List<CategoryModel> getAll() throws Exception; 
	
	//取单个类别
	public CategoryModel getByNo(Integer no)throws Exception;

	//新增类别
	public void add(CategoryModel cm)throws Exception; 
	
	//修改
	public void change(CategoryModel cm)throws Exception; 
	
	public void delete(CategoryModel cm)throws Exception; 
}
