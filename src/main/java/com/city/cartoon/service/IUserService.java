package com.city.cartoon.service;

import java.util.List;

import com.city.cartoon.model.CartoonModel;
import com.city.cartoon.model.CategoryModel;
import com.city.cartoon.model.UserModel;

public interface IUserService {
	
	//验证账号和密码是否合法
	public UserModel validate(Integer id,String password)throws Exception; 
	
	//更改用户信息
	public void ChangeUserInfo(UserModel um)throws Exception;
	
	//用户注册
	public void RegisterUser(UserModel um)throws Exception;
	
	//取指定用户
	public UserModel getByNo(Integer no)throws Exception;
	
	//增加追漫
	public void addCartoon(int userNo,int CartoonNo) throws Exception;
	
	//取追漫画列表
	public List<CartoonModel> getCartoonByUserid(Integer id)throws Exception;
	
	//增加喜好
	public void addCategory(Integer userid, int[] categorys)throws Exception;
	
	//	清除原有的喜好
	public void deleteCategory(int userid) throws Exception;

	public List<CategoryModel> getLikeCategory(Integer userid)throws Exception;

	public void CancleCartoon(int userNo, int cartoonNo)throws Exception;
	
}
