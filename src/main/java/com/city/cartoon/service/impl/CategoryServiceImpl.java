package com.city.cartoon.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.city.cartoon.mapper.ICartoonMapper;
import com.city.cartoon.mapper.ICategoryMapper;
import com.city.cartoon.model.CartoonModel;
import com.city.cartoon.model.CategoryModel;
import com.city.cartoon.service.ICategoryService;

@Service("categoryService")
@Transactional(rollbackFor = {Exception.class})
public class CategoryServiceImpl implements ICategoryService{
	
	@Autowired
	private ICategoryMapper categoryMapper=null;

	
	@Override
	public List<CategoryModel> getAll() throws Exception {
		
		return categoryMapper.selectAll();
	}

// TODO Auto-generated method stub
	@Override
	public CategoryModel getByNo(Integer no) throws Exception {
		
		return categoryMapper.selectByNo(no);
	}

	@Override
	public void add(CategoryModel cm) throws Exception {
		// TODO Auto-generated method stub
		categoryMapper.Insert(cm);
	}

	@Override
	public void change(CategoryModel cm) throws Exception {
		// TODO Auto-generated method stub
		categoryMapper.Update(cm);
	}

	@Override
	public void delete(CategoryModel cm) throws Exception {
		// TODO Auto-generated method stub
		categoryMapper.Delete(cm);
	}
	
	

}
