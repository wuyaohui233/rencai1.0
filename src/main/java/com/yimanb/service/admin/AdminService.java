package com.yimanb.service.admin;

import java.util.List;

import com.yimanb.entity.admin.Admin;
import com.yimanb.entity.user.User;
import org.apache.ibatis.annotations.Param;


public interface AdminService {
	/**登录
	 * @param name账号
	 * @param pwd密码
	 * @return
	 */
	Admin QueryAdminLogin(@Param("name")String name, @Param("pwd")String pwd);
	
	/**更新密码
	 * @param new_pwd新密码
	 * @param name账号
	 * @param pwd旧密码
	 */
	Integer UpdatePwdAdmin(@Param("new_pwd")String new_pwd,@Param("name")String name,@Param("pwd")String pwd);
	
	/**查询用户列表
	 * @param user 用户实体类
	 * @param start_page 起始数据
	 * @param page_size 数据量
	 * @return
	 */
	List<User> QueryUserAdmin(@Param("mybatis/user")User user, @Param("skip_size")Integer skip_size, @Param("page_size")Integer page_size);
}
