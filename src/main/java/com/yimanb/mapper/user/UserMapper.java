package com.yimanb.mapper.user;

import com.yimanb.entity.user.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;


public interface UserMapper {
	
	/**用户注册
	 * @param user
	 * @return
	 */
	Integer InsertUser(User user);
	
	/**更新密码
	 * @param id
	 * @param pwd
	 */
	@Update("update user set password = #{pwd} where id = #{id}")
	void UpdatePwd(@Param("id")Integer id,@Param("pwd")String pwd);
	
	/**登录
	 * @param name
	 * @param password
	 * @return
	 */
	@Select("select * from user where name = #{name} and password = #{password}")
	User QueryMsg(@Param("name")String name,@Param("password")String password);
	
	/**查询注册名是否存在
	 * @param name
	 * @return
	 */
	@Select("select count(*)=0 from user where name = #{name}")
	boolean QueryNameRegist(@Param("name")String name);
	
	/**查询个人信息
	 * @param id
	 * @return
	 */
	@Select("select id,id_card,phone,name,sex,type,status,DATE_FORMAT(data_time,'%Y-%m-%d %T') as data_time from user where id = #{id}")
	User QueryPersonalMsg(@Param("id")Integer id);


}
