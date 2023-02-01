package com.city.cartoon.service;

import com.city.cartoon.model.UserModel;

public interface IAdministratorService {
	//验证账号和密码是否合法
	public UserModel validate(Integer id,String Password)throws Exception; 
}
