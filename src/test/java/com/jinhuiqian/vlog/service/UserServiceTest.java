package com.jinhuiqian.vlog.service;

import com.jinhuiqian.vlog.VlogApplication;
import com.jinhuiqian.vlog.common.Gender;
import com.jinhuiqian.vlog.model.dto.LoginDto;
import com.jinhuiqian.vlog.model.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.digest.DigestUtils;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author 231
 * @date 2020-12-05 16:06
 */
@SpringBootTest(classes = VlogApplication.class)
@Slf4j
class UserServiceTest {

    @Resource
    private UserService userService;

    @Test
    void login() {
        LoginDto loginDto = LoginDto.builder()
                .phone("15161659812")
                .password("123456")
                .build();
        boolean flag = userService.login(loginDto);
        assertTrue(flag);
    }

    @Test
    void getUser() {
        User user = userService.getUser("15161659812");
        log.info(String.valueOf(user));
    }

    @Test
    void updateUser() {
        User user = User.builder()
                .phone("18552415135")
                .password(DigestUtils.md5Hex("123456"))
                .nickname("jinhuiqian")
                .avatar("")
                .gender(Gender.secret.type)
                .birthday(LocalDate.of(2000,11,29))
                .address("江苏南京")
                .build();
        userService.updateUser(user);
    }
}
