package com.city.cartoon.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.city.cartoon.model.CartoonModel;

public interface ICartoonMapper {
		
		//取得最新上架漫画
		public List<CartoonModel> selectByTime() throws Exception;
		//取得有限个分类
		public List<CartoonModel> selectByType(String typename) throws Exception;
		//取得单个漫画
		public CartoonModel selectByNo(Integer no) throws Exception;
		
		 
		//取得全部漫画,分页
		public List<Object> selectByAll (@Param("page") Integer page,@Param("rows")Integer rows) throws Exception; 
		
		 
		
		//取得全部分类，按类别分页
		public List<CartoonModel> selectByTypeALL(@Param("typename")String typename,@Param("page") Integer page,@Param("rows")Integer rows) throws Exception; 
		
		//取得总页数
		public int selectPageCount(int rows) throws Exception;
		//取得总个数
		public int selectCount()throws Exception;
		
		
		
		
		//按类别取总页数
		public int selectPageCountByTypename(int rows,String typename) throws Exception;
		//按类别取总个数
		public int selectCountByTypename(String typename) throws Exception;

		//按漫画名称模糊查询
		public List<CartoonModel> selectByName(@Param("cartoonName")String cartoonName)throws Exception;
		
		//根据连载状态查询
		public List<CartoonModel> selectByUpdateState(String stateName) throws Exception;
		
		
		
		
		
		
		//增加漫画
		public void insert(CartoonModel cm) throws Exception; 
		
		//修改漫画
		public void update(CartoonModel cm) throws Exception; 
		
		//删除漫画
		public void delete(Integer cartoonid) throws Exception; 
}
