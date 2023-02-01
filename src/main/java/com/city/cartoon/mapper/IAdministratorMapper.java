package com.city.cartoon.mapper;

import org.apache.ibatis.annotations.Param;

import com.city.cartoon.model.AdministratorModel;

public interface IAdministratorMapper {
	public AdministratorModel validate(@Param("id")Integer id,@Param("password")String Password) throws Exception;
}
