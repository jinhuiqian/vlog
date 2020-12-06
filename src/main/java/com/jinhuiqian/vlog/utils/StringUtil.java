package com.jinhuiqian.vlog.utils;

import org.springframework.stereotype.Component;

import java.util.Random;

/**
 * @author 231
 * @date 2020-12-06 11:12
 */

public class StringUtil {
    public static String getVerifyCode() {
        Random random = new Random();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < 6; i++) {
            stringBuilder.append(String.valueOf(random.nextInt(10)));
        }
        return stringBuilder.toString();
    }
}
