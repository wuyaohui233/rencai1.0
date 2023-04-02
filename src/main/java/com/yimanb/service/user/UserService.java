package com.yimanb.service.user;

import java.util.Map;

import com.yimanb.entity.user.User;
import org.apache.ibatis.annotations.Param;


public interface UserService {
	
	/**用户注册
	 * @param user
	 * @return
	 */
	Map<String,Object> InsertUser(User user);
	
	/**登录
	 * @param name
	 * @param password
	 * @return
	 */
	Map<String,Object> QueryMsg(@Param("name")String name,@Param("password")String password);
	
	/**更新密码
	 * @param id
	 * @param pwd
	 */
	void UpdatePwd(@Param("id")Integer id,@Param("pwd")String pwd);
	
	/**查询注册名是否存在
	 * @param name
	 * @return
	 */
	boolean QueryNameRegist(@Param("name")String name);
	
	/**查询用户个人信息
	 * @param id
	 * @return
	 */
	User QueryPersonalMsg(Integer id);
}
