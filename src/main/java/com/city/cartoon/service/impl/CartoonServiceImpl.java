package com.city.cartoon.service.impl;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestParam;

import com.city.cartoon.mapper.ICartoonMapper;
import com.city.cartoon.model.CartoonModel;
import com.city.cartoon.service.ICartoonService;


//AOP和hibernate实现业务层实现类
@Service("cartoonService")
@Transactional(rollbackFor = {Exception.class})
public class CartoonServiceImpl implements ICartoonService {
		
		@Autowired
		private ICartoonMapper cartoonMapper=null;

		// 按日期降序取6个
		@Override
		public List<CartoonModel> getByTime() throws Exception {
			List<CartoonModel> list=cartoonMapper.selectByTime();
			return list;
		}
		// 按类别名称取6个
		@Override
		public List<CartoonModel> getByType(String typename) throws Exception {
			List<CartoonModel> list=cartoonMapper.selectByType(typename);
			return list;
		}	
		// 取指定ID的漫画
		@Override
		public CartoonModel getByNo(Integer no) throws Exception {
			
			return cartoonMapper.selectByNo(no);
		}
		
		
		// 取得所有
		@Override
		public  List<Object> getByAll(Integer page,Integer rows) throws Exception {
			List<Object> list=cartoonMapper.selectByAll(rows*(page-1), rows);
			
			return list;
		}
	
		//取得总页数
		
		@Override
		public int getPageCount(int rows) throws Exception {
			
			int page=0;
			page=(int) Math.ceil((double)getCount()/rows );
			return page ;
		}
		//取总个数
		@Override
		public int getCount() throws Exception {
			
			return cartoonMapper.selectCount();
		}
	

	
	
		// 按类别取所有
		@Override
		public List<CartoonModel> getByTypeALL(String typename, Integer page,Integer rows) throws Exception {
			List<CartoonModel>list=cartoonMapper.selectByTypeALL(typename, rows*(page-1),rows );
		
			return list;
		}

	
	
		//取得按类别分类总页数
	
		@Override
		public int getPageCountByTypename(int rows,String typename) throws Exception {
			
			int page=0;
			page=(int) Math.ceil((double)getCountByTypename(typename)/rows );
			return page ;
		}
		//取按类别分类总个数
		@Override
		public int getCountByTypename(String typename) throws Exception {
			
			return cartoonMapper.selectCountByTypename(typename);
		}

	
	
	
	
	
	
	
	
	//按名称模糊查询
	@Override
	public List<CartoonModel> getByName(String cartoonName) throws Exception {
		return cartoonMapper.selectByName(cartoonName);
	}
	
	//根据连载状态查询漫画
	@Override
	public List<CartoonModel> getByUpdateState(String stateName) throws Exception {
		return cartoonMapper.selectByUpdateState(stateName);
	}
	


	
	// 新增漫画
		@Override
		public void add(CartoonModel cm) throws Exception {
			cartoonMapper.insert(cm);
		}
		@Override
		public void update(CartoonModel cm) throws Exception {
			// TODO Auto-generated method stub
			cartoonMapper.update(cm);
		}
		@Override
		public void delete(Integer cartoonid) throws Exception {
			// TODO Auto-generated method stub
			cartoonMapper.delete(cartoonid);
		}
		
		
		
		

}
