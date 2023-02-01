package com.city.cartoon.service.impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.city.cartoon.mapper.IUserMapper;
import com.city.cartoon.model.CartoonModel;
import com.city.cartoon.model.CategoryModel;
import com.city.cartoon.model.UserModel;
import com.city.cartoon.service.IUserService;

@Service("userService")
@Transactional(rollbackFor = {Exception.class})
public class UserServiceImpl  implements IUserService{
	
	@Autowired
	private IUserMapper userMapper=null;
	
	// 验证用户登录
	@Override
	public UserModel validate(Integer id, String Password) throws Exception {
		
		return userMapper.validate(id, Password);
	}
	
	// 修改用户信息
	@Override
	public void ChangeUserInfo(UserModel um) throws Exception {
		userMapper.UpdateUserInfo(um);
		
	}
	// 用户注册
	@Override
	public void RegisterUser(UserModel um) throws Exception {
		userMapper.InsertUser(um);
		
	}
	
	// 按用户UID取
	@Override
	public UserModel getByNo(Integer no) throws Exception {
		
		return userMapper.selectByNo(no);
	}
	
	
	// 添加追漫
	@Override
	public void addCartoon(int userNo, int CartoonNo) throws Exception {
		userMapper.addCartoon(userNo, CartoonNo);
		
	}
	
	
	// 显示追漫
	@Override
	public List<CartoonModel> getCartoonByUserid(Integer id)throws Exception  {
		
		return userMapper.selectCartoonByUserid(id);
	}
	
	// 增加喜爱类别
	@Override
	public void addCategory(Integer userid, int[] categorys) throws Exception{
		
		userMapper.InsertCategory(userid, categorys);
	}
	
	// 删除原有喜爱
	@Override
	public void deleteCategory(int userid) throws Exception {
		
		userMapper.deleteCategory(userid);
	}
	// 获取当前喜爱的类别
	@Override
	public List<CategoryModel> getLikeCategory(Integer userid) throws Exception {
		
		return userMapper.selectLikeCategory(userid);
	}
	
	// TODO Auto-generated method stub
	@Override
	public void CancleCartoon(int userNo, int cartoonNo) throws Exception {
		userMapper.CancleCartoon(userNo, cartoonNo);
		
	}

	

}
