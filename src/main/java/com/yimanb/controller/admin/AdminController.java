package com.yimanb.controller.admin;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.yimanb.common.result.Result;
import com.yimanb.entity.admin.Admin;
import com.yimanb.entity.user.User;
import com.yimanb.service.admin.AdminService;
import com.yimanb.util.token.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;

@CrossOrigin
@Controller
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	private AdminService aService;
	
	/**管理员登录
	 * @param name 账号
	 * @param password 密码
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value="/aLogin.do",produces={"application/json;charset=UTF-8"})
	@ResponseBody
	public Result<Object> aLogin(String name, String password) throws IOException {
		Admin adminMsg = aService.QueryAdminLogin(name, password);
		if(adminMsg!= null && adminMsg.getType().equals("root")) {
			String token = JwtUtil.sign(adminMsg.getName(),null,adminMsg.getType());//登录token
			System.out.println("token:"+token);
			return Result.ok(token);
		}
		return Result.fail();
	}
	
	/** 更新管理员密码
	 * @param pwd 旧密码
	 * @param new_pwd 新密码
	 * @param token
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value="/updatePwdAdmin.do",produces={"text/html;charset=utf-8"})
	@ResponseBody
	public String updatePwdAdmin(String pwd,String new_pwd,String token) throws IOException {
		
		Map<String,Object> json = new HashMap<String,Object>();
		
//		验证登录状态
		boolean verify = JwtUtil.verify(token);
		if(!verify || !JwtUtil.getUserType(token).equals("root")) {
			json.put("code", 201);
			json.put("msg", "无权访问或账号已过期！");
			return JSON.toJSONString(json);
		}
		
		Integer updatePwdAdmin = aService.UpdatePwdAdmin(new_pwd, JwtUtil.getUsername(token).toString(), pwd);
		if(updatePwdAdmin == 0) {
			json.put("code", 400);
			json.put("msg", "更新失败！");
			return JSON.toJSONString(json);
		}
		
		json.put("code", 200);
		json.put("msg", "更新成功！");
		return JSON.toJSONString(json);
		
	}
	
	/** 查询用户列表
	 * @param user 用户信息实体类
	 * @param page 当前页
	 * @param page_size 页面数据数
	 * @param token
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value="/QueryUserAdmin.do",produces={"text/html;charset=utf-8"})
	@ResponseBody
	public String QueryUser(User user, Integer page, Integer page_size, String token) throws IOException {
		Map<String,Object> json = new HashMap<String,Object>();
		
//		验证登录状态
		boolean verify = JwtUtil.verify(token);
		if(!verify || !JwtUtil.getUserType(token).equals("root")) {
			json.put("code", 201);
			json.put("msg", "无权访问或账号已过期！");
			return JSON.toJSONString(json);
		}
		
		Integer start_page = (page - 1)*page_size;
		List<User> queryUser = aService.QueryUserAdmin(user, start_page, page_size);
		json.put("code", 200);
		json.put("msg", "查询成功！");
		json.put("data", queryUser);
		
		return JSON.toJSONString(json);
	}
	
	
}
