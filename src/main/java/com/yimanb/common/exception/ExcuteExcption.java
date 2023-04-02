package com.yimanb.common.exception;

/**
 * 抛出异常并返回结果
 */
public class ExcuteExcption extends RuntimeException {
    public static final Integer SUCCESS_CODE = 200;
    public static final Integer ERROR_CODE = 500;

    /**
     * 错误码
     */
    private Integer code;

    private Object data;

    public ExcuteExcption(Integer code, String message) {
        this(code, message, null, null);
    }

    public ExcuteExcption(String message) {
        super(message);
    }

    public ExcuteExcption(String message, Throwable cause) {
        super(message, cause);
    }

    public ExcuteExcption(Integer code, String message, Object data, Throwable cause) {
        super(message, cause);
        this.code = code;
        this.data = data;
    }

    public Integer getCode() {
        return code;
    }

    public Object getData() {
        return data;
    }
}