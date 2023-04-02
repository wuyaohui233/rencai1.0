package com.yimanb.controller.user;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.yimanb.entity.user.User;
import com.yimanb.service.user.UserService;
import com.yimanb.util.token.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;

@CrossOrigin
@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService uService;

	@RequestMapping(value="/test.do",produces={"text/html;charset=utf-8"})
	@ResponseBody
	public String test(String pwd,String token) throws IOException {

		Map<String,Object> json = new HashMap<String,Object>();

		return JSON.toJSONString(json);
	}

	/**修改密码
	 * @param pwd 新密码
	 * @param token
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value="/updatePwd.do",produces={"text/html;charset=utf-8"})
	@ResponseBody
	public String updatePwd(String pwd,String token) throws IOException {
		
		Map<String,Object> json = new HashMap<String,Object>();
		
//		验证登录状态
		boolean verify = JwtUtil.verify(token);
		if(!verify) {
			json.put("code", 201);
			json.put("msg", "无权访问或账号已过期！");
			return JSON.toJSONString(json);
		}
		
		uService.UpdatePwd(Integer.parseInt(JwtUtil.getUserId(token)), pwd);
		
		json.put("code", 200);
		json.put("msg", "更新成功！");
		
		return JSON.toJSONString(json);
	}
	
	/**注册
	 * @param user 注册参数
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value="/uRegist.do",produces={"text/html;charset=utf-8"})
	@ResponseBody
	public String userRegist(User user) throws IOException {
		Map<String,Object> json = new HashMap<String,Object>();
		
		Map<String, Object> insertUser = uService.InsertUser(user);
		json.put("code", insertUser.get("code"));
		json.put("msg", insertUser.get("msg"));
		
		return JSON.toJSONString(json);
	}
	
	/**查询个人信息
	 * @param token
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value="/queryUserMsg.do",produces={"text/html;charset=utf-8"})
	@ResponseBody
	public String queryUserMsg(String token) throws IOException {
		
		Map<String,Object> json = new HashMap<String,Object>();
		
//		验证登录状态
		boolean verify = JwtUtil.verify(token);
		if(!verify) {
			json.put("code", 201);
			json.put("msg", "无权访问或账号已过期！");
			return JSON.toJSONString(json);
		}
		
		int id = Integer.parseInt(JwtUtil.getUserId(token));
		User queryPersonalMsg = uService.QueryPersonalMsg(id);
		
		json.put("code", 200);
		json.put("msg", "查询成功！");
		json.put("data", queryPersonalMsg);
		
		return JSON.toJSONString(json);
		
	}
	
	/**登录
	 * @param name 账号
	 * @param password 密码
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value="/uLogin.do",produces={"text/html;charset=utf-8"})
	@ResponseBody
	public String uLogin(String name,String password) throws IOException {
		
		Map<String,Object> json = new HashMap<String,Object>();
		
		Map<String,Object> map = uService.QueryMsg(name, password);
		if(map.get("code").equals(200)) {
			json.put("token",map.get("token"));
		}
		json.put("code",map.get("code"));
		json.put("msg",map.get("msg"));
		
		return JSON.toJSONString(json);
	}
	
}
