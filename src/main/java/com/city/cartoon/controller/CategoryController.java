package com.city.cartoon.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.city.cartoon.model.CartoonModel;
import com.city.cartoon.model.CategoryModel;
import com.city.cartoon.result.ResultList;
import com.city.cartoon.result.ResultOne;
import com.city.cartoon.service.ICategoryService;

@RestController		//@Controller+@ResponseBody
@RequestMapping(value="/api/category")//映射地址
@CrossOrigin(origins = "*",maxAge = 3600)//允许跨域访问，所有端口
public class CategoryController {
	
	@Autowired
	private ICategoryService categoryService=null;//注入业务层对象
	
	@RequestMapping("/getcategory.mvc")
	public ResultList<CategoryModel> getCategoryList()throws Exception{
		ResultList<CategoryModel> results= new ResultList<CategoryModel>();
		results.setStatus("OK");
		results.setMessage("取得类别列表成功");
		results.setList(categoryService.getAll());
		
		
		return results;
	}
	
	
	
	//新增
		@RequestMapping(value="/addcategory.mvc")
		public ResultOne<String> AddCartoon(CategoryModel cm) throws Exception{
		
			categoryService.add(cm);
			ResultOne<String> result=new ResultOne<String>();
			result.setStatus("OK");
			//categoryService.getByNo(cm.getCartoonid());
			result.setMessage("新增类别成功");
			return result;
		}
		
		//修改
		@RequestMapping(value="/updatecategory.mvc")
		public ResultOne<String> UpdateCartoon(CategoryModel cm) throws Exception{
				
			categoryService.change(cm);
			ResultOne<String> result=new ResultOne<String>();
			result.setStatus("OK");
			result.setMessage("修改类别成功");
			return result;
		}
		
		//删除
		@RequestMapping(value="/deletecategory.mvc")
		public ResultOne<String> DeleteCartoon(CategoryModel cm) throws Exception{
						
			categoryService.delete(cm);
			ResultOne<String> result=new ResultOne<String>();
			result.setStatus("OK");
			result.setMessage("删除类别成功");
			return result;
		}
}
