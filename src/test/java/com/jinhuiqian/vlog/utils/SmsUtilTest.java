package com.jinhuiqian.vlog.utils;

import com.jinhuiqian.vlog.VlogApplication;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author 231
 * @date 2020-12-06 10:20
 */
@SpringBootTest(classes = VlogApplication.class)
@Slf4j
class SmsUtilTest {

    @Resource
    private SmsUtil smsUtil;

    @Test
    void sendSms() {
        smsUtil.sendSms("18552415135","123456");
    }
}
