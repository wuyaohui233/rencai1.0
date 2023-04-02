package com.yimanb.common.result;

import java.util.HashMap;
import java.util.Map;

public class ReturnMap {


	public static Map<String, Object> success(){
		Map<String, Object> m = new HashMap<String, Object>();
		m.put("code",Constants.SUCCESS_CODE);
		m.put("data","");
		m.put("msg","操作成功");
		return m;
	};


	public static Map<String, Object> success(Object data){
		Map<String, Object> m = new HashMap<String, Object>();
		m.put("code",Constants.SUCCESS_CODE);
		m.put("data",data);
		m.put("msg","操作成功");
		return m;
	};

	public static Map<String, Object> success(Object data,String msg){
		Map<String, Object> m = new HashMap<String, Object>();
		m.put("code",Constants.SUCCESS_CODE);
		m.put("data",data);
		m.put("msg",msg);
		return m;
	};

	public static Map<String, Object> error(){
		Map<String, Object> m = new HashMap<String, Object>();
		m.put("code",Constants.ERROR_CODE);
		m.put("data",null);
		m.put("msg","操作失败");
		return m;
	};

	public static Map<String, Object> error(String msg){
		Map<String, Object> m = new HashMap<String, Object>();
		m.put("code",Constants.ERROR_CODE);
		m.put("data",null);
		m.put("msg",msg);
		return m;
	};


	public static Map<String, Object> error(Object data,String msg){
		Map<String, Object> m = new HashMap<>();
		m.put("code",Constants.ERROR_CODE);
		m.put("data",data);
		m.put("msg",msg);
		return m;
	};



	public static Map<String, Object> return_map(Integer code,Object data,String msg){
		Map<String, Object> m = new HashMap<String, Object>();
		m.put("code",code);
		m.put("data",data);
		m.put("msg",msg);
		return m;
	};

}
