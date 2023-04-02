package com.yimanb.common.result;

/**
 * msg 描述
 * code 响应码
 * data 数据
 * total 数据总数
 * extra 扩展
 */
public class Result<T> {
	
	//返回码
    private Integer code;
 
    //返回消息
    private String message;
    
    //总数
    private Integer total;
 
    //返回数据
    private T data;
 
    public Result(){}
    
	// 返回数据
    protected static <T> Result<T> build(T data) {
        Result<T> result = new Result<T>();
        if (data != null)
            result.setData(data);
        return result;
    }
    
    protected static <T> Result<T> build(ResultCodeEnum resultCodeEnum) {
        Result<T> result = new Result<T>();
        result.setCode(resultCodeEnum.getCode());
        result.setMessage(resultCodeEnum.getMessage());
        return result;
    }
 
    public static <T> Result<T> build(T body, Integer code, String message) {
        Result<T> result = build(body);
        result.setCode(code);
        result.setMessage(message);
        return result;
    }
 
    public static <T> Result<T> build(T body, ResultCodeEnum resultCodeEnum) {
        Result<T> result = build(body);
        result.setCode(resultCodeEnum.getCode());
        result.setMessage(resultCodeEnum.getMessage());
        return result;
    }

    public static <T> Result<T> build(String msg, ResultCodeEnum resultCodeEnum) {
        Result<T> result = new Result<T>();
        result.setCode(resultCodeEnum.getCode());
        result.setMessage("["+resultCodeEnum.getMessage()+"]:"+msg);
        return result;
    }
    
    public static <T> Result<T> build(T body,Integer total, ResultCodeEnum resultCodeEnum) {
        Result<T> result = build(body);
        result.setTotal(total);
        result.setCode(resultCodeEnum.getCode());
        result.setMessage(resultCodeEnum.getMessage());
        return result;
    }
 
    /**
     * 操作成功
     * @param data  baseCategory1List
     * @param <T>
     * @return
     */
    public static<T> Result<T> ok(T data,Integer total){
//        Result<T> result = build(data);
        return build(data,total,ResultCodeEnum.SUCCESS);
    }
    
    public static<T> Result<T> ok(){
        return Result.ok(null);
    }
    
    public static<T> Result<T> ok(T data){
//    	System.out.println("成功方法aaaa");
//      Result<T> result = build(data);
      return build(data,ResultCodeEnum.SUCCESS);
  }
 
    public static<T> Result<T> fail(){
        return Result.fail(null);
    }
 
    /**
     * 操作失败
     * @param <T>
     * @return
     */
    public static<T> Result<T> fail(ResultCodeEnum enumCode){
//        Result<T> result = build(data);
        return build(enumCode);
    }

    /**
     * 操作失败
     * @param <T>
     * @return
     */
    public static<T> Result<T> fail(String msg,ResultCodeEnum enumCode){
//        Result<T> result = build(data);
        return build(msg,enumCode);
    }
    
 
    public Result<T> message(String msg){
        this.setMessage(msg);
        return this;
    }
 
    public Result<T> code(Integer code){
        this.setCode(code);
        return this;
    }

    
    //@Data 生成
	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}

	@Override
	public String toString() {
		return "Result [code=" + code + ", message=" + message + ", total=" + total + ", data=" + data + "]";
	}
	
}
