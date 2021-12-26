package com.example.backend.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.backend.entity.User;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 禤成伟
 * @since 2021-12-25
 */
public interface UserService extends IService<User> {

    /**
     * 使用密码登录
     * @param user
     * @return 登录成功则返回 token ,登录失败则返回失败原因
     */
    String loginByPassword(User user);

    /**
     * 获取用户信息
     * @param token 用户 token
     * @return 用户信息
     */
    Object getUserInformation(String token);
}
