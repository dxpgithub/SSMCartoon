package com.city.cartoon.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.city.cartoon.mapper.IAdministratorMapper;
import com.city.cartoon.mapper.IUserMapper;
import com.city.cartoon.model.AdministratorModel;
import com.city.cartoon.model.UserModel;
import com.city.cartoon.service.IAdministratorService;

public class AdministratorServiceImpl implements IAdministratorService{
	
	@Autowired
	private IAdministratorMapper administratorMapper=null;
	//验证登录
	@Override
	public AdministratorModel validate(Integer id, String Password) throws Exception {
		
		return administratorMapper.validate(id, Password);
	}

}
