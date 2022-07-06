package com.debing.liao.common;

import lombok.Data;

/**
 * @author liaodebing
 */
@Data
public class Result<T> {

    /**
     * return code
     */
    private String code;

    /**
     * return message
     *
     * it is error message at most position
     *
     * it is null when return success
     */
    private String message;

    /**
     * return data object
     */
    private T data;

    public static<T> Result<T> successOf(T data) {
        return of("200", null, data);
    }

    public static<T> Result<T> failOf(String message, T data) {
        return of("500", message, data);
    }

    public static<T> Result<T> of(String code, String message, T data) {
        Result<T> result = new Result<T>();
        result.setCode(code);
        result.setMessage(message);
        result.setData(data);

        return result;
    }

}
