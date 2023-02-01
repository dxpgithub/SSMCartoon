package com.city.cartoon.service.impl;


import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestParam;

import com.city.cartoon.model.CartoonModel;
import com.city.cartoon.service.ICartoonService;


//AOP和hibernate实现业务层实现类
@Service("cartoonService")
@Transactional(rollbackFor = {Exception.class})
public class CartoonServiceImpl implements ICartoonService {
	
	@Autowired
	private SessionFactory sessionFactory=null;
	
	// 新增漫画
	@Override
	public void add(CartoonModel cm) throws Exception {
		sessionFactory.getCurrentSession().save(cm);
	}
	
	// 取得所有
	@Override
	public  List<CartoonModel> getByAll(Integer rows,Integer page) throws Exception {
		
		return sessionFactory.
				getCurrentSession().
				createQuery("from CartoonModel",CartoonModel.class).
				setFirstResult(rows*(page-1)).
				setMaxResults(rows).
				getResultList();
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
		
		return sessionFactory.
				getCurrentSession().
				createQuery("select count(*) from CartoonModel",Long.class).
				getSingleResult().intValue();
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
			
			return sessionFactory.
					getCurrentSession().
					createQuery("select count(cm) from CartoonModel cm,CategoryModel cate WHERE cm.category.categoryno=cate.categoryno and cate.cname=:typename ",Long.class).
					setParameter("typename",typename).
					getSingleResult().intValue();
		}

	// 按日期降序取6个
	@Override
	public List<CartoonModel> getByTime() throws Exception {
		String hql="select cm from CartoonModel cm order by cm.cartoondate desc";
		return sessionFactory.
				getCurrentSession().
				createQuery(hql,CartoonModel.class).
				setMaxResults(6).
				getResultList();
	}
	
	// 按类别名称取6个
	@Override
	public List<CartoonModel> getByType(String typename) throws Exception {
		String hql="select cm "
				+ "from CartoonModel cm,CategoryModel cate "
				+ "WHERE cm.category.categoryno=cate.categoryno and cate.cname=:typename order by cm.cartoondate desc";
		return sessionFactory.
				getCurrentSession().
				createQuery(hql,CartoonModel.class).
				setMaxResults(6).
				setParameter("typename",typename).
				getResultList();
	}
	
	// 按类别取所有
	@Override
	public List<CartoonModel> getByTypeALL(String typename,Integer rows, Integer page) throws Exception {
		String hql="from CartoonModel";
		if(typename!=null) {
			hql="select cm from CartoonModel cm,CategoryModel cate where  cm.category.categoryno=cate.categoryno and cate.cname=:typename";
		}
		return sessionFactory.
				getCurrentSession().
				createQuery(hql,CartoonModel.class).
				setParameter("typename",typename).
				setFirstResult(rows*(page-1)).
				setMaxResults(rows).
				getResultList();
	}

	
	// 取指定ID的漫画
	@Override
	public CartoonModel getByNo(Integer no) throws Exception {
		
		return sessionFactory.
				getCurrentSession().
				createQuery("from CartoonModel where cartoonid=:no",CartoonModel.class).
				setParameter("no",no).
				getSingleResult();
	}
	
	//按名称模糊查询
	@Override
	public List<CartoonModel> getByName(String cartoonName) throws Exception {
		String hql="select cm from CartoonModel cm,CategoryModel cate where cm.cartoonname like :cartoonName and cm.category.categoryno=cate.categoryno ";
		return sessionFactory.
				getCurrentSession().
				createQuery(hql,CartoonModel.class).
				setParameter("cartoonName","%"+cartoonName+"%").
				getResultList();
	}
	
	//根据连载状态查询漫画
	@Override
	public List<CartoonModel> getByUpdateState(String stateName) throws Exception {
		String hql="select cm from CartoonModel cm,StateModel sta where cm.state.stateid=sta.stateid and sta.sname=:stateName";
		
		return sessionFactory.
				getCurrentSession().
				createQuery(hql,CartoonModel.class).
				setParameter("stateName",stateName).
				getResultList();
	}
	


	
	
	
}
