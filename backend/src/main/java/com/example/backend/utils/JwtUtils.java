package com.example.backend.utils;

import io.jsonwebtoken.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * @author helen
 * @since 2019/10/16
 */
public class JwtUtils {

    /**
     * token过期时间
     */
    public static final long EXPIRE = 1000 * 60 * 60 * 24 * 7;
    /**
     * 秘钥
     */
    public static final String APP_SECRET = "ukc8BDbRigUDaY6pZFfWus2jZWLPHO";

    /**
     * 生成token字符串
     * @param id
     * @param username
     * @return
     */
    public static String getJwtToken(String id, String username){

        return Jwts.builder()
                .setHeaderParam("typ", "JWT")
                .setHeaderParam("alg", "HS256")
                .setSubject("login-register-demo")
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRE))

                //设置token主体部分 ，存储用户信息
                .claim("id", id)
                .claim("username", username)

                .signWith(SignatureAlgorithm.HS256, APP_SECRET)
                .compact();
    }


    /**
     * Returns {@code true} if the specified JWT compact string represents a signed JWT (aka a 'JWS'), {@code false}
     * otherwise.
     * <p>
     * <p>Note that if you are reasonably sure that the token is signed, it is more efficient to attempt to
     * parse the token (and catching exceptions if necessary) instead of calling this method first before parsing.</p>
     *
     * @param jwt the compact serialized JWT to check
     * @return {@code true} if the specified JWT compact string represents a signed JWT (aka a 'JWS'), {@code false}
     * otherwise.
     */
    public static boolean isSigned(String jwt){
        return Jwts.parser().setSigningKey(APP_SECRET).isSigned(jwt);
    }

    /**
     * 判断 token 是否存在与有效
     * @param jwtToken
     * @return
     */
    public static boolean checkToken(String jwtToken) {
        if(jwtToken == null || "".equals(jwtToken)) {
            return false;
        }
        try {
            Jwts.parser().setSigningKey(APP_SECRET).parseClaimsJws(jwtToken);
        } catch (JwtException jwtException) {
            jwtException.printStackTrace();
            return false;
        }
        return true;
    }

    /**
     * 判断 token 是否存在与有效
     * @param request
     * @return
     */
    public static boolean checkToken(HttpServletRequest request) {
        String jwtToken = request.getHeader("token");
        return checkToken(jwtToken);
    }

    /**
     * 根据 token 字符串获取用户 id
     * @param jwtToken
     * @return
     */
    public static String getIdByJwtToken(String jwtToken) {
        if(jwtToken == null || "".equals(jwtToken)) {
            return null;
        }
        Jws<Claims> claimsJws = Jwts.parser().setSigningKey(APP_SECRET).parseClaimsJws(jwtToken);
        Claims claims = claimsJws.getBody();
        return (String)claims.get("id");
    }


    /**
     * 根据 token 字符串获取用户 id
     * @param request
     * @return
     */
    public static String getIdByJwtToken(HttpServletRequest request) {
        String jwtToken = request.getHeader("token");
        return getIdByJwtToken(jwtToken);
    }

}
