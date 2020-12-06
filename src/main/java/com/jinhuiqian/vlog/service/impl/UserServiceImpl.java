package com.jinhuiqian.vlog.service.impl;

import com.jinhuiqian.vlog.mapper.UserMapper;
import com.jinhuiqian.vlog.model.dto.LoginDto;
import com.jinhuiqian.vlog.model.dto.PhoneLoginDto;
import com.jinhuiqian.vlog.model.entity.User;
import com.jinhuiqian.vlog.service.RedisService;
import com.jinhuiqian.vlog.service.UserService;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.sql.SQLException;
import java.time.LocalDateTime;

/**
 * @author 231
 * @date 2020-12-05 16:01
 */
@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper userMapper;

    @Resource
    private RedisService redisService;

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

    @Override
    public boolean phoneLogin(PhoneLoginDto phoneLoginDto) {
        //无论是否存在该手机号，均先校验验证码，通过再分两种情况处理为登录和注册
        //检查redis中之前存储的验证码
        boolean flag = redisService.existsKey(phoneLoginDto.getPhone());
        if(flag) {
            //取出redis中之前存储的验证码
            String saveCode = redisService.getValue(phoneLoginDto.getPhone(), String.class);
            //和前端传的验证码对比，比对成功
            if(saveCode.equalsIgnoreCase(phoneLoginDto.getCode())) {
                //查看数据库该手机号用户是否存在
                User user = getUser(phoneLoginDto.getPhone());
                //存在就登录成功
                if(user!= null) {
                    return true;
                }else {
                    //不存在该手机号，就构建新用户记录，补充必备字段写入数据库，一件注册并登录（密码留空，用户可后期修改）
                    User user1 = User.builder()
                            .phone(phoneLoginDto.getPhone())
                            .nickname("新用户")
                            .avatar("/static/default.jpg")
                            .createTime(LocalDateTime.now())
                            .build();
                    try {
                        userMapper.insert(user1);
                        return true;
                    } catch (SQLException throwables) {
                        System.err.println("新增用户出现异常");
                    }
                }
                return false;
            }
        }
        return false;
    }

    @Override
    public User updateUser(User user) {
        //先查出数据库原用户信息
        User savedUser = getUser(user.getPhone());
        //相应字段的修改，注意前端传值的时候这些字段如果没有修改也需要传原值，以免被覆盖为空
        savedUser.setPassword(DigestUtils.md5Hex(user.getPassword()));
        savedUser.setNickname(user.getAddress());
        savedUser.setAvatar(user.getAvatar());
        savedUser.setGender(user.getGender());
        savedUser.setBirthday(user.getBirthday());
        savedUser.setAddress(user.getAddress());
        //更新数据
        try {
            userMapper.updateUser(savedUser);
        } catch (SQLException throwables) {
            System.err.println("修改用户信息出现异常");
        }
        //被修改后的用户信息返回
        return savedUser;
    }
}


















