package com.jinhuiqian.vlog.mapper;

import com.jinhuiqian.vlog.VlogApplication;
import com.jinhuiqian.vlog.common.Gender;
import com.jinhuiqian.vlog.model.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.cli.Digest;
import org.apache.commons.codec.digest.DigestUtils;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author 231
 * @date 2020-12-05 14:20
 */
@SpringBootTest(classes = VlogApplication.class)
@Slf4j
class UserMapperTest {
    //注入UserMapper的实例
    @Resource
    private UserMapper userMapper;

    @Test
    void insert() throws Exception{
        User user = User.builder()
                .phone("15161659812")
                .password(DigestUtils.md5Hex("123456"))
                .nickname("钱锦辉")
                .avatar("1.jpg")
                .gender(Gender.female.type)
                .birthday(LocalDate.now())
                .address("江苏无锡")
                .createTime(LocalDateTime.now())
                .build();
        userMapper.insert(user);
    }

    @Test
    void findUserByPhone() throws SQLException {
        User user = userMapper.findUserByPhone("15161659812");
        log.info(String.valueOf(user));
    }
}
