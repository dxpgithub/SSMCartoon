package com.city.cartoon.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.city.cartoon.model.CategoryModel;
import com.city.cartoon.model.StateModel;
import com.city.cartoon.result.ResultList;
import com.city.cartoon.service.ICategoryService;
import com.city.cartoon.service.IStateService;

@RestController		//@Controller+@ResponseBody
@RequestMapping(value="/api/state")//映射地址
@CrossOrigin(origins = "*",maxAge = 3600)//允许跨域访问，所有端口
public class StateController {
	@Autowired
	private IStateService stateService=null;//注入业务层对象
	
	@RequestMapping("/getstate.mvc")
	public ResultList<StateModel> getCategoryList()throws Exception{
		ResultList<StateModel> results= new ResultList<StateModel>();
		results.setStatus("OK");
		results.setMessage("取得类别列表成功");
		results.setList(stateService.getAll());
		
		
		return results;
	}
}
