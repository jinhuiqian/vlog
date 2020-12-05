package com.jinhuiqian.vlog.service.impl;

import com.jinhuiqian.vlog.mapper.UserMapper;
import com.jinhuiqian.vlog.model.dto.LoginDto;
import com.jinhuiqian.vlog.model.entity.User;
import com.jinhuiqian.vlog.service.UserService;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.sql.SQLException;

/**
 * @author 231
 * @date 2020-12-05 16:01
 */
@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper userMapper;

    @Override
    public boolean login(LoginDto loginDto) {
        User user = getUser(loginDto.getPhone());
        if(user != null){
            return DigestUtils.md5Hex(loginDto.getPassword()).equals(user.getPassword());
        }
        return false;
    }

    @Override
    public User getUser(String phone) {
        User user = null;
        try {
            user = userMapper.findUserByPhone(phone);
        } catch (SQLException throwables) {
            System.out.println("根据手机号查找用户出现异常");
        }
        return user;
    }
}
