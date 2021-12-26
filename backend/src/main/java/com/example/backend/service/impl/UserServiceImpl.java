package com.example.backend.service.impl;

import com.example.backend.entity.User;
import com.example.backend.mapper.UserMapper;
import com.example.backend.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.backend.utils.JwtUtils;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 禤成伟
 * @since 2021-12-25
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Override
    public String loginByPassword(User user) {

        User member = baseMapper.selectByUsername(user.getUsername());

        if(null == member){
            return "用户不存在";
        }

        if(!member.getPassword().equals(user.getPassword())){
            return "密码不正确";
        }

        return JwtUtils.getJwtToken(member.getId(),member.getUsername());
    }
}
