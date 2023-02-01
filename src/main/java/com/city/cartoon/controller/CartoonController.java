package com.city.cartoon.controller;


import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.city.cartoon.model.CartoonModel;
import com.city.cartoon.model.UserModel;
import com.city.cartoon.result.ResultList;
import com.city.cartoon.result.ResultOne;
import com.city.cartoon.service.ICartoonService;

@RestController		//@Controller+@ResponseBody
@RequestMapping(value="/api/cartoon")//映射地址
@CrossOrigin(origins = "*",maxAge = 3600)//允许跨域访问，所有端口
public class CartoonController {
	
	@Autowired
	private ICartoonService cartoonService=null;//注入业务层对象
	
	
	
	/*
	 * 1.按日期降序取6个,完成日期：2022-5-29
	 */
	@RequestMapping("/showByTime.mvc")
	public ResultList<CartoonModel> getByTime()throws Exception{
		ResultList<CartoonModel> results= new ResultList<CartoonModel>();
		results.setStatus("OK");
		results.setMessage("取得漫画成功");
		results.setList(cartoonService.getByTime());
		return results;
	}
			
	/*
	 * 2.取得6个指定类型		
	 */
	@RequestMapping("/showByType.mvc")
	public ResultList<CartoonModel> getByType(@RequestParam String typename)throws Exception{
		ResultList<CartoonModel> results= new ResultList<CartoonModel>();
		results.setStatus("OK");
		results.setMessage("取得指定漫画成功");
		results.setList(cartoonService.getByType(typename));
		return results;
	}
	
	//3.取得指定的漫画对象
	@RequestMapping(value="/get.mvc",method=RequestMethod.GET)
	public ResultOne<CartoonModel> getByNo(@RequestParam Integer no)throws Exception{
			
		ResultOne<CartoonModel> result=new ResultOne<CartoonModel>();
			result.setStatus("OK");
			result.setMessage("取得指定漫画成功");
			result.setResult(cartoonService.getByNo(no));
		return result;
			
	}
	
	
	
	/*
	 * 4.取得类型的全部，分页
	 */
	@RequestMapping("/showTypeALL.mvc")
	public ResultList<CartoonModel> getByTypeALL(@RequestParam(required = false)String typename,@RequestParam(value="page",required=false,defaultValue="1") int page,@RequestParam(value="rows",required=false,defaultValue="12") int rows)throws Exception{
		ResultList<CartoonModel> results= new ResultList<CartoonModel>();
		results.setStatus("OK");
		results.setMessage("取得漫画成功");
		results.setList(cartoonService.getByTypeALL(typename,page,rows));
		results.setPageCount(cartoonService.getPageCountByTypename(rows,typename));
		results.setCount(cartoonService.getCountByTypename(typename));
		
		return results;
	}
	
	
	
	
	//5.取全部，分页
	@RequestMapping("/showALL.mvc")
	public ResultList<Object> getByALL(@RequestParam(value="page",required=false,defaultValue="1") int page,@RequestParam(value="rows",required=false,defaultValue="12") int rows)throws Exception{
		ResultList<Object> results= new ResultList<Object>();
		results.setStatus("OK");
		results.setMessage("取得漫画成功");
		results.setList(cartoonService.getByAll(page,rows));
		results.setPageCount(cartoonService.getPageCount(rows));
		results.setCount(cartoonService.getCount());
		return results;
	}
	
	
	
	
	
	/*
	 * 6.按漫画名称模糊查询
	 */
	@RequestMapping("/showByName.mvc")
	public ResultList<CartoonModel> getByName(@RequestParam(required = false) String cartoonName)throws Exception{
		ResultList<CartoonModel> results= new ResultList<CartoonModel>();
		results.setStatus("OK");
		results.setMessage("取得类似名称漫画成功");
		results.setList(cartoonService.getByName(cartoonName));
		
		
		return results;
	}
	
	/*
	 * 7.按连载状态查询
	 */
	@RequestMapping("/showByState.mvc")
	public ResultList<CartoonModel> getByUpdateState(@RequestParam String stateName)throws Exception{
		ResultList<CartoonModel> results= new ResultList<CartoonModel>();
		results.setStatus("OK");
		results.setMessage("取得相关状态漫画成功");
		results.setList(cartoonService.getByUpdateState(stateName));
		return results;
	}
	
	

	//增加产品方法， 请求地址为：/add，返回：message为增加产品成功；status为”OK”.
	@RequestMapping(value="/add.mvc")
	public ResultOne<String> add(CartoonModel cm,@RequestParam(required = false)MultipartFile cartoonPhoto,HttpServletRequest request) throws Exception{
		if(cartoonPhoto!=null && (!cartoonPhoto.isEmpty())) {
			cm.setContenttype(cartoonPhoto.getContentType());
			cm.setFilename("photo"+cm.getCartoonid()+ cartoonPhoto.getOriginalFilename().substring(cartoonPhoto.getOriginalFilename().lastIndexOf(".")));
			cm.setPhoto(cartoonPhoto.getBytes());
			
		
			
		}
		cartoonService.add(cm);
		ResultOne<String> result=new ResultOne<String>();
		result.setStatus("OK");
		result.setMessage("增加漫画成功");
		return result;
	}
	
	
	
	
	/*
	 * 8.显示产品图片的控制方法，
	 */
	
	@RequestMapping("/showphoto.mvc")
	public ResponseEntity<byte[]> showphoto(Integer no) throws Exception{
		CartoonModel cm=cartoonService.getByNo(no);
		if(cm!=null&&cm.getContenttype()!=null) {
			HttpHeaders responseHeaders = new HttpHeaders();
			responseHeaders.set("Content-Type", cm.getContenttype());
			
			return new ResponseEntity<byte[]>(cm.getPhoto(), responseHeaders,HttpStatus.OK);
		}
		else {
			return null;
		}	
	}
	
	//新增漫画
	@RequestMapping(value="/addcartoon.mvc")
	public ResultOne<String> AddCartoon(CartoonModel cm,@RequestParam(required = false)MultipartFile cartoonphoto,HttpServletRequest request) throws Exception{
		if(cartoonphoto!=null && (!cartoonphoto.isEmpty())) {
			cm.setContenttype(cartoonphoto.getContentType());
			cm.setFilename("photo"+cartoonphoto.getOriginalFilename().substring(cartoonphoto.getOriginalFilename().lastIndexOf(".")));
			cm.setPhoto(cartoonphoto.getBytes());
		}
		cartoonService.add(cm);
		ResultOne<String> result=new ResultOne<String>();
		result.setStatus("OK");
		cartoonService.getByNo(cm.getCartoonid());
		result.setMessage("新的漫画编号："+cm.getCartoonid());
		return result;
	}
	
	
	
	//修改
		@RequestMapping(value="/updatecartoon.mvc")
		public ResultOne<String> UpdateCartoon(CartoonModel cm,@RequestParam(required = false)MultipartFile cartoonphoto,HttpServletRequest request) throws Exception{
			if(cartoonphoto!=null && (!cartoonphoto.isEmpty())) {
				cm.setContenttype(cartoonphoto.getContentType());
				cm.setFilename("photo"+cartoonphoto.getOriginalFilename().substring(cartoonphoto.getOriginalFilename().lastIndexOf(".")));
				cm.setPhoto(cartoonphoto.getBytes());
			}
			cartoonService.update(cm);
			ResultOne<String> result=new ResultOne<String>();
			result.setStatus("OK");
			cartoonService.getByNo(cm.getCartoonid());
			result.setMessage("修改成功");
			return result;
	}
	
	
		//删除
		@RequestMapping(value="/deletecartoon.mvc")
		public ResultOne<String> DeleteCartoon(Integer cartoonid) throws Exception{
			
				cartoonService.delete(cartoonid);
				ResultOne<String> result=new ResultOne<String>();
				result.setStatus("OK");
				//cartoonService.getByNo(cm.getCartoonid());
				result.setMessage("删除成功");
				return result;
		}
}

