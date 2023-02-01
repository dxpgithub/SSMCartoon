package com.city.cartoon.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.city.cartoon.model.CartoonModel;
import com.city.cartoon.model.CategoryModel;
import com.city.cartoon.model.UserModel;
import com.city.cartoon.result.ResultList;
import com.city.cartoon.result.ResultOne;
import com.city.cartoon.service.IUserService;

@RestController		
@RequestMapping(value="/api/user")//映射地址
@CrossOrigin(origins = "*",maxAge = 3600)//允许跨域访问，所有端口
public class UserController {
	@Autowired
	private IUserService userService=null;//注入业务层对象
	
	
		//验证用户登录
		@RequestMapping(value="/validate.mvc")
		public ResultOne<UserModel> Validate(@RequestParam Integer id,@RequestParam String password)throws Exception{
			
			ResultOne<UserModel> result=new ResultOne<UserModel>();
			
				if(userService.validate(id, password)!=null) {
					result.setStatus("OK");
					result.setMessage("用户登录成功");
					result.setResult(userService.validate(id, password));
				}else {
					result.setStatus("ERROR");
					result.setMessage("无此用户");
				}
			
			
			return result;	
		}
		
		//新增用户
		@RequestMapping(value="/registerUser.mvc")
		public ResultOne<String> RegisterUser(UserModel um,@RequestParam(required = false)MultipartFile userphoto,HttpServletRequest request) throws Exception{
			if(userphoto!=null && (!userphoto.isEmpty())) {
				um.setContenttype(userphoto.getContentType());
				um.setFilename("photo"+um.getUserid()+ userphoto.getOriginalFilename().substring(userphoto.getOriginalFilename().lastIndexOf(".")));
				um.setPhoto(userphoto.getBytes());
			}
			userService.RegisterUser(um);
			ResultOne<String> result=new ResultOne<String>();
			result.setStatus("OK");
			userService.getByNo(um.getUserid());
			result.setMessage("您的UID为："+um.getUserid());
			return result;
		}
		//修改用户
		@RequestMapping(value="/userupdate.mvc")
		public ResultOne<String> UserUpdate(UserModel um,@RequestParam(required = false)MultipartFile userphoto,HttpServletRequest request) throws Exception{
			
			if(userphoto!=null && (!userphoto.isEmpty())) {
				um.setContenttype(userphoto.getContentType());
				um.setFilename("photo"+um.getUserid()+userphoto.getOriginalFilename().substring(userphoto.getOriginalFilename().lastIndexOf(".")));
				um.setPhoto(userphoto.getBytes());
				
				
			}
			userService.ChangeUserInfo(um);
			ResultOne<String> result=new ResultOne<String>();
			result.setStatus("OK");
			result.setMessage("修改信息成功");
			return result;
		}
		
		//显示用户头像
		@RequestMapping("/userphoto.mvc")
		public ResponseEntity<byte[]> showphoto(Integer no) throws Exception{
			UserModel um=userService.getByNo(no);
			
			if(um!=null&&um.getContenttype()!=null) {
				HttpHeaders responseHeaders = new HttpHeaders();
				responseHeaders.set("Content-Type", um.getContenttype());
				
				return new ResponseEntity<byte[]>(um.getPhoto(), responseHeaders,HttpStatus.OK);
			}
			else {
				return null;
			}	
		}
		
		
		/*
		 * 增添追漫
		 */
		
		@RequestMapping(value="/followCartoon.mvc")
		public ResultOne<String>  addCartoon(int userNo,int CartoonNo) throws Exception{
			
			userService.addCartoon(userNo, CartoonNo);
			ResultOne<String> result=new ResultOne<String>();
			result.setStatus("OK");
			result.setMessage("追漫成功");
			return result;
		}
		/*
		 * 取消追漫
		 */
		@RequestMapping(value="/cancleCartoon.mvc")
		public ResultOne<String>  CancleCartoon(int userNo,int CartoonNo) throws Exception{
			
			userService.CancleCartoon(userNo, CartoonNo);
			ResultOne<String> result=new ResultOne<String>();
			result.setStatus("OK");
			result.setMessage("取消追漫");
			return result;
		}
		
		
		/*
		 * 显示追漫
		 */
		
		@RequestMapping("/getfollowcartoon.mvc")
		public ResultList<CartoonModel> getCartoonByUserid(Integer id)throws Exception{
			ResultList<CartoonModel> results= new ResultList<CartoonModel>();
			results.setStatus("OK");
			results.setMessage("取得漫画成功");
			results.setList(userService.getCartoonByUserid(id));
			return results;
		}
		
		/*
		 * 添加喜爱类别
		 */
		@RequestMapping(value="/addcategory.mvc")
		public ResultOne<String> AddCategory(Integer userid, int[] categorys) throws Exception{
			userService.deleteCategory(userid);
			userService.addCategory(userid,categorys);
			ResultOne<String> result=new ResultOne<String>();
			result.setStatus("OK");
			result.setMessage("增添喜爱成功");
			return result;
		}		
		
		
		/*
		 * 显示当前的喜爱类别
		 */

		@RequestMapping("/getlikecategory.mvc")
		public ResultList<CategoryModel> getLikeCategory(Integer userid)throws Exception{
			ResultList<CategoryModel> results= new ResultList<CategoryModel>();
			results.setStatus("OK");
			results.setMessage("取得喜好成功");
			results.setList(userService.getLikeCategory(userid));
			return results;
		}
		
}
