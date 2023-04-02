package com.yimanb.service.admin;

import java.util.List;

import com.yimanb.mapper.admin.AdminMapper;
import com.yimanb.entity.admin.Admin;
import com.yimanb.entity.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class AdminServiceImpl implements AdminService {
	
	@Autowired(required = false)
	private AdminMapper aMapper;

	@Override
	public Admin QueryAdminLogin(String name, String pwd) {
		if(name==null||name.equals("")) {
			return null;
		}
		if(pwd==null||pwd.equals("")) {
			return null;
		}
		return aMapper.QueryAdminLogin(name, pwd);
	}

	@Override
	public Integer UpdatePwdAdmin(String new_pwd, String name, String pwd) {
		if(new_pwd==null||new_pwd.equals("")) {
			return 0;
		}
		if(name==null||name.equals("")) {
			return 0;
		}
		if(pwd==null||pwd.equals("")) {
			return 0;
		}
		aMapper.UpdatePwdAdmin(new_pwd, name, pwd);
		return 1;
	}

	@Override
	public List<User> QueryUserAdmin(User user, Integer start_page, Integer page_size) {
		return aMapper.QueryUserAdmin(user, start_page, page_size);
	}
	
}
