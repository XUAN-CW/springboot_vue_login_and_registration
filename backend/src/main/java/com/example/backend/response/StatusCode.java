package com.example.backend.response;

/**
 * 请求状态码
 * <p/>
 * HTTP 是个很好的设计，所以状态码设计我直接照抄，为了避免跟 HTTP 混淆，
 * HTTP 状态码的后面加上两位数就是我的状态码。例如:
 * <ul>
 *     <li> 200(HTTP 请求成功状态码) -> 20000(我的请求成功状态码)
 * </ul>
 *
 * @author 禤成伟
 * @date 2021-12-24 23:38
 * @see <a href="https://baike.baidu.com/item/HTTP/243074?fr=aladdin">HTTP</a>
 */
public enum StatusCode {

    /**
     * 请求成功
     */
    OK(20000,"请求成功"),

    /**
     * 当前请求需要用户验证
     */
    UNAUTHORIZED(40100,"当前请求需要用户验证"),

    /**
     * 登录失败
     */
    LOGGED_FAILURE(40101,"登录失败"),

    /**
     * 懒得定义那么多错误就用这个
     */
    ERROR(49999,"ERROR");

    public final int code;
    public final String massage;

    StatusCode(Integer code,String massage){
        this.code = code;
        this.massage = massage;
    }


}
