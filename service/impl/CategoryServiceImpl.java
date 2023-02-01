package com.city.cartoon.service.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.city.cartoon.model.CartoonModel;
import com.city.cartoon.model.CategoryModel;
import com.city.cartoon.service.ICategoryService;

@Service("categoryService")
@Transactional(rollbackFor = {Exception.class})
public class CategoryServiceImpl implements ICategoryService{
	
	@Autowired
	private SessionFactory sessionFactory=null;
	
	@Override
	public List<CategoryModel> getAll() throws Exception {
		
		return sessionFactory.
				getCurrentSession().
				createQuery("from CategoryModel",CategoryModel.class).
				getResultList();
	}
	
	

}
