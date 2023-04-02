package com.yimanb.common.result;

public enum ResultCodeEnum {
	 
	    SUCCESS(200,"请求成功"),
	    FAIL(201, "请求失败"),
	    SERVICE_ERROR(2012, "服务异常"),
	    DATA_ERROR(204, "数据异常"),
	    ILLEGAL_REQUEST(205, "非法请求"),
	    REPEAT_SUBMIT(206, "重复提交"),
	    ARGUMENT_VALID_ERROR(210, "参数校验异常"),
	 
	    LOGIN_AUTH(208, "未登陆"),
	    PERMISSION(209, "没有权限"),
	    ACCOUNT_ERROR(214, "账号不正确"),
	    PASSWORD_ERROR(215, "密码不正确"),
	    LOGIN_MOBLE_ERROR( 216, "账号不正确"),
	    ACCOUNT_STOP( 217, "账号已停用"),
	    NODE_ERROR( 218, "该节点下有子节点，不可以删除"),
	    ACCOUNT_EXPIRE( 219, "账号过期");
	 
	    private Integer code;
	 
	    private String message;
	 
	    private ResultCodeEnum(Integer code, String message) {
	        this.code = code;
	        this.message = message;
	    }

		public Integer getCode() {
			return code;
		}

		public String getMessage() {
			return message;
		}
		
	    
}
