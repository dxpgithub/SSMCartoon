package com.city.cartoon.service.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.city.cartoon.model.CartoonModel;
import com.city.cartoon.model.UserModel;
import com.city.cartoon.service.IUserService;

@Service("userService")
@Transactional(rollbackFor = {Exception.class})
public class UserServiceImpl implements IUserService {
	
	@Autowired
	private SessionFactory sessionFactory=null;
	
	// 用户登录验证
	@Override
	public UserModel validate(Integer id, String Password) throws Exception {
		
		String hql="select um from UserModel um where um.userid=:id and um.userpwd=:password";
		
		
		return sessionFactory.
				getCurrentSession().
				createQuery(hql,UserModel.class).
				setParameter("id",id).
				setParameter("password", Password).
				getSingleResult();
	}
	
	
	// 修改用户信息
	@Override
	public void ChangeUserInfo(UserModel um) throws Exception {
		sessionFactory.getCurrentSession().update(um);
	}
	//用户注册
	@Override
	public void RegisterUser(UserModel um) throws Exception {
		sessionFactory.getCurrentSession().save(um);

	}

	//查用户头像
	@Override
	public UserModel getByNo(Integer no)throws Exception {
		
		return sessionFactory.
				getCurrentSession().
				createQuery("from UserModel where userid=:id",UserModel.class).
				setParameter("id",no).
				getSingleResult();
	}

	// 添加追漫
	@Override
	public void addCartoon(int userNo, int cartoonNo) throws Exception {
		
		UserModel um=sessionFactory.
				getCurrentSession().
				createQuery("from UserModel where userid=:userNo",UserModel.class).
				setParameter("userNo",userNo).
				getSingleResult();
		
		CartoonModel cm=sessionFactory.
				getCurrentSession().
				createQuery("from CartoonModel where cartoonid=:cartoonNo",CartoonModel.class).
				setParameter("cartoonNo",cartoonNo).
				getSingleResult();
		
		
		um.getCartoons().add(cm);
		cm.getUsers().add(um);
		//session.getTransaction().commit();
		
	}
	
	

}
