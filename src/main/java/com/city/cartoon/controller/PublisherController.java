package com.city.cartoon.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.city.cartoon.model.CategoryModel;
import com.city.cartoon.model.PublisherModel;
import com.city.cartoon.model.StateModel;
import com.city.cartoon.result.ResultList;
import com.city.cartoon.result.ResultOne;
import com.city.cartoon.service.IPublisherService;
import com.city.cartoon.service.IStateService;

@RestController		
@RequestMapping(value="/api/publisher")//映射地址
@CrossOrigin(origins = "*",maxAge = 3600)//允许跨域访问，所有端口
public class PublisherController {
	@Autowired
	private IPublisherService publisherService=null;//注入业务层对象
	
	@RequestMapping("/getpublisher.mvc")
	public ResultList<PublisherModel> getCategoryList()throws Exception{
		ResultList<PublisherModel> results= new ResultList<PublisherModel>();
		results.setStatus("OK");
		results.setMessage("取得出版社列表成功");
		results.setList(publisherService.getAll());
		
		
		return results;
	}
	
	
	
	

	//新增
		@RequestMapping(value="/addpublisher.mvc")
		public ResultOne<String> AddPublisher(PublisherModel pm) throws Exception{
		
			publisherService.add(pm);
			ResultOne<String> result=new ResultOne<String>();
			result.setStatus("OK");
			//categoryService.getByNo(cm.getCartoonid());
			result.setMessage("新增出版社成功");
			return result;
		}
		
		//修改
		@RequestMapping(value="/updatepublisher.mvc")
		public ResultOne<String> UpdatePublisher(PublisherModel pm) throws Exception{
				
			publisherService.change(pm);
			ResultOne<String> result=new ResultOne<String>();
			result.setStatus("OK");
			result.setMessage("修改出版社成功");
			return result;
		}
		
		//删除
		@RequestMapping(value="/deletepublisher.mvc")
		public ResultOne<String> DeletePublisher(PublisherModel pm) throws Exception{
						
			publisherService.delete(pm);
			ResultOne<String> result=new ResultOne<String>();
			result.setStatus("OK");
			result.setMessage("删除出版社成功");
			return result;
		}
}
