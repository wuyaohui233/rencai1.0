package com.yimanb.service.user;

import java.util.HashMap;
import java.util.Map;

import com.yimanb.mapper.user.UserMapper;
import com.yimanb.entity.user.User;
import com.yimanb.util.token.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper uMapper;
	
	@Override
	public void UpdatePwd(Integer id, String pwd) {
		uMapper.UpdatePwd(id, pwd);
	}

	/**
	 *注册
	 */
	@Override
	public Map<String,Object> InsertUser(User user) {
		Map<String,Object> map = new HashMap<String,Object>();
		
		String name = user.getName();
		if(name == null || name.equals("")) {
			map.put("code", 400);
			map.put("msg", "用户名格式错误");
			return map;
		}
		
		boolean queryNameRegist = uMapper.QueryNameRegist(name);
		if(!queryNameRegist) {
			map.put("code", 400);
			map.put("msg", "用户名已存在");
			return map;
		}
		
		String pwd = user.getPassword();
		if(pwd == null || pwd.equals("")) {
			map.put("code", 400);
			map.put("msg", "密码格式错误");
			return map;
		}
		
		user.setType("用户");
		user.setStatus("正常");
		
		uMapper.InsertUser(user);
		
		map.put("code", 200);
		map.put("msg", "注册成功！");
		
		return map;
	}

	@Override
	public Map<String,Object> QueryMsg(String name, String password) {
		Map<String,Object> map = new HashMap<String,Object>();
		User queryMsg = uMapper.QueryMsg(name, password);
		if(queryMsg!= null) {
			if(queryMsg.getStatus().equals("封禁")) {
				map.put("code", 400);
				map.put("msg", "当前账号已被封禁！");
				return map;
			}
			
			if(queryMsg.getStatus().equals("正常")) {
				map.put("code", 200);
				map.put("msg", "登录成功");
				map.put("uid", queryMsg.getId());
				map.put("type", queryMsg.getType());
				
				String token = JwtUtil.sign(queryMsg.getName(),queryMsg.getId().toString(),queryMsg.getType());//登录token
				
				map.put("token", token);
				
				return map;
			}
		}
		map.put("code", 400);
		map.put("msg", "登录失败，账号密码错误！");
		return map;
	}

	@Override
	public boolean QueryNameRegist(String name) {
		return uMapper.QueryNameRegist(name);
	}

	@Override
	public User QueryPersonalMsg(Integer id) {
		return uMapper.QueryPersonalMsg(id);
	}

}
