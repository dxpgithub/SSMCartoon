package com.city.cartoon.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.city.cartoon.model.CartoonModel;
import com.city.cartoon.model.CategoryModel;
import com.city.cartoon.model.UserModel;

public interface IUserMapper {
	//验证账号和密码是否合法
		public UserModel validate(@Param("id")Integer id,@Param("password")String password)throws Exception; 
		
		//更改用户信息
		public void UpdateUserInfo(UserModel um)throws Exception;
		
		//用户注册
		public void InsertUser(UserModel um)throws Exception;
		
		//取指定用户
		public UserModel selectByNo(Integer no)throws Exception;
		
		//给指定产品增加指定区域。每次增加一个区域。
		public void addCartoon(@Param("userNo")int userNo,@Param("CartoonNo")int CartoonNo) throws Exception;
		
		//显示追漫
		public List<CartoonModel> selectCartoonByUserid(Integer id)throws Exception;
		
		//增加喜爱类别
		public void InsertCategory(@Param("userid")Integer userid,@Param("categorys") int[] categorys)throws Exception; 
		
		//	清除原有的喜好
		public void deleteCategory(int userid) throws Exception;
		
		//获取当前喜爱的类别
		public List<CategoryModel> selectLikeCategory(Integer userid)throws Exception;
		
		public void CancleCartoon(@Param("userNo")int userNo,@Param("CartoonNo") int cartoonNo)throws Exception;
}
