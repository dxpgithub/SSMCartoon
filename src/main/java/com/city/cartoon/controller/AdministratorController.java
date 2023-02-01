package com.city.cartoon.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.city.cartoon.mapper.IAdministratorMapper;
import com.city.cartoon.model.AdministratorModel;
import com.city.cartoon.model.UserModel;
import com.city.cartoon.result.ResultOne;

@RestController		
@RequestMapping(value="/api/administrator")//映射地址
@CrossOrigin(origins = "*",maxAge = 3600)//允许跨域访问，所有端口
public class AdministratorController {
	
	@Autowired
	private IAdministratorMapper administratorMapper=null;
	//验证用户登录
			@RequestMapping(value="/validate.mvc")
			public ResultOne<AdministratorModel> Validate(@RequestParam Integer id,@RequestParam String password)throws Exception{
				
				ResultOne<AdministratorModel> result=new ResultOne<AdministratorModel>();
				
					if(administratorMapper.validate(id, password)!=null) {
						result.setStatus("Administrator");
						result.setMessage("登录成功");
						result.setResult(administratorMapper.validate(id, password));
					}else {
						result.setStatus("ERROR");
						result.setMessage("无此用户");
					}
				
				
				return result;	
	}
			
			
			
			
			
	
}
