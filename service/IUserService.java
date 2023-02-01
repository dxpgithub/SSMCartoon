package com.city.cartoon.service;

import com.city.cartoon.model.CartoonModel;
import com.city.cartoon.model.UserModel;

public interface IUserService {
	
	//验证账号和密码是否合法
	public UserModel validate(Integer id,String Password)throws Exception; 
	
	//更改用户信息
	public void ChangeUserInfo(UserModel um)throws Exception;
	
	//用户注册
	public void RegisterUser(UserModel um)throws Exception;
	
	//取指定用户
	public UserModel getByNo(Integer no)throws Exception;
	
	//给指定产品增加指定区域。每次增加一个区域。
	public void addCartoon(int userNo,int CartoonNo) throws Exception;
	
}
