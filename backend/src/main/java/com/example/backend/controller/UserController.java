package com.example.backend.controller;


import com.example.backend.entity.User;
import com.example.backend.response.Result;
import com.example.backend.response.StatusCode;
import com.example.backend.service.UserService;
import com.example.backend.utils.JwtUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 禤成伟
 * @since 2021-12-25
 */
@RestController
@CrossOrigin
@RequestMapping("/backend/user")
public class UserController {

    @Resource
    UserService userService;

    @PostMapping("loginByPassword")
    public Result<String> loginByPassword(@RequestBody User user){
        String tokenOrMassage = userService.loginByPassword(user);
        if(JwtUtils.isSigned(tokenOrMassage)){
            return Result.ok(tokenOrMassage);
        }else {
            return Result.error(StatusCode.LOGGED_FAILURE);
        }
    }


    @GetMapping("getUserInformation")
    public Result<User> getUserInformation(@RequestHeader("token") String token){
        //这里先不考虑 token 过期问题,关于 token 的问题全部交给网关解决
        String uid = JwtUtils.getIdByJwtToken(token);
        User user = userService.getById(uid);
        return Result.ok(user);
    }



}

