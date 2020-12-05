package com.jinhuiqian.vlog.controller;

import com.jinhuiqian.vlog.common.ResponseResult;
import com.jinhuiqian.vlog.common.ResultCode;
import com.jinhuiqian.vlog.model.dto.LoginDto;
import com.jinhuiqian.vlog.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author 231
 * @date 2020-12-05 16:15
 */
@RestController
@RequestMapping(value = "/api/user")
@Slf4j
public class UserController {
    @Resource
    private UserService userService;

    @PostMapping(value = "/login")
    ResponseResult login(@RequestBody LoginDto loginDto) {
        log.info("loginDto:{loginDto}");
        boolean flag = userService.login(loginDto);
        if(flag){
            return ResponseResult.success();
        }else {
            return ResponseResult.failure(ResultCode.USER_SIGN_IN_FAIL);
        }
    }
}
