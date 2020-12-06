package com.jinhuiqian.vlog.service;

import com.jinhuiqian.vlog.model.dto.LoginDto;
import com.jinhuiqian.vlog.model.dto.PhoneLoginDto;
import com.jinhuiqian.vlog.model.entity.User;

/**
 * @author 231
 * @date 2020-12-05 15:59
 */
public interface UserService {

    /**
     *
     * @param loginDto 登录dto对象
     * @return boolean
     */
    boolean login(LoginDto loginDto);

    /**
     * 根据手机号查找用户
     */
    User getUser(String phone);

    /**
     * 手机短信验证码登录
     *
     */
    boolean phoneLogin(PhoneLoginDto phoneLoginDto);

    /**
     * 修改用户信息
     */
    User updateUser(User user);
}
