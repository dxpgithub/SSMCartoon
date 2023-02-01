package com.city.cartoon.service;

import java.util.List;
import com.city.cartoon.model.CartoonModel;

public interface ICartoonService {
	
	//取得最新上架漫画
	public List<CartoonModel> getByTime() throws Exception; 
	//取得有限个分类
	public List<CartoonModel> getByType(String typename) throws Exception;
	//取得单个漫画
	public CartoonModel getByNo(Integer no) throws Exception;
	
	
	
	//取得全部漫画
	public List<Object> getByAll (Integer rows, Integer page) throws Exception; 
	
	//取得全部分类
	public List<CartoonModel> getByTypeALL(String typename,Integer rows, Integer page) throws Exception; 
	
	
	
	
	
	//取得总页数
	public int getPageCount(int rows) throws Exception;
	//取得总个数
	public int getCount()throws Exception;
	

	
	
	//按类别取总页数
	public int getPageCountByTypename(int rows,String typename) throws Exception;
	//按类别取总个数
	public int getCountByTypename(String typename) throws Exception;
	
	//按漫画名称模糊查询
	public List<CartoonModel> getByName(String cartoonName)throws Exception;
	//根据连载状态查询
	public List<CartoonModel> getByUpdateState(String stateName) throws Exception;
	
	
	//增加漫画
	public void add(CartoonModel cm) throws Exception;
	public void update(CartoonModel cm)throws Exception;
	public void delete(Integer cartoonid)throws Exception;
	
		
	
}
