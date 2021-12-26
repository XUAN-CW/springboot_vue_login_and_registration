package com.example.backend.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.backend.entity.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author 禤成伟
 * @since 2021-12-25
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {

    /**
     * <p>
     * 根据用户名查询
     * </p>
     *
     * @param username 用户名
     * @return
     */
    User selectByUsername(String username);
}
