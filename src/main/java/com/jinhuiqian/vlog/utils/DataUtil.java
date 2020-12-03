package com.jinhuiqian.vlog.utils;

import com.jinhuiqian.vlog.model.Card;

import java.util.Arrays;
import java.util.List;

/**
 * @author 231
 * @date 2020-12-03 14:26
 */
public class DataUtil {
    public static List<Card> initCards(){
        Card[] cards = new Card[]{
                Card.builder()
                        .id(1)
                        .title("java")
                        .bgImg("https://niit-soft.oss-cn-hangzhou.aliyuncs.com/share-app/Java.jpg")
                        .content("java")
                        .build(),
                Card.builder()
                        .id(1)
                        .title("java Script")
                        .bgImg("https://niit-soft.oss-cn-hangzhou.aliyuncs.com/share-app/JavaScript.jpg")
                        .content("java Script")
                        .build(),
                Card.builder()
                        .id(1)
                        .title("Linux")
                        .bgImg("https://niit-soft.oss-cn-hangzhou.aliyuncs.com/share-app/Linux.jpg")
                        .content("Linux")
                        .build(),
                Card.builder()
                        .id(1)
                        .title("MySql")
                        .bgImg("https://niit-soft.oss-cn-hangzhou.aliyuncs.com/share-app/MySQL.jpg")
                        .content("MySql")
                        .build(),
                Card.builder()
                        .id(1)
                        .title("Python")
                        .bgImg("https://niit-soft.oss-cn-hangzhou.aliyuncs.com/share-app/Python.jpg")
                        .content("MySql")
                        .build(),
        };
        return Arrays.asList(cards);
    }
}