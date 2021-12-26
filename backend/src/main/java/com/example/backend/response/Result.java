package com.example.backend.response;


/**
 * @author 禤成伟
 * @date 2021-12-24 23:34
 */
public class Result<T> {

    private int code;
    private String message;
    private T data;

    private Result(StatusCode statusCode){
        this.code = statusCode.code;
        this.message = statusCode.massage;
    }

    public static <T> Result<T> ok(T data){
        Result<T> result = new Result<>(StatusCode.OK);
        result.data = data;
        return result;
    }

    public static <T> Result<T> error(){
        return new Result<>(StatusCode.ERROR);
    }

    public static <T> Result<T> error(String massage){
        Result<T> result = new Result<>(StatusCode.ERROR);
        result.message = massage;
        return result;
    }

    public int getCode() {
        return code;
    }

    public Result<T> setCode(int code) {
        this.code = code;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public Result<T> setMessage(String message) {
        this.message = message;
        return this;
    }

    public T getData() {
        return data;
    }

    public Result<T> setData(T data) {
        this.data = data;
        return this;
    }
}
