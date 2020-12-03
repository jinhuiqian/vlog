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
                        .title("java学习")
                        .bgImg("http://niit-soft.oss-cn-hangzhou.aliyuncs.com/share-app/java.jpg")
                        .content("java学习")
                        .build(),
                Card.builder()
                        .id(1)
                        .title("java Script学习")
                        .bgImg("http://niit-soft.oss-cn-hangzhou.aliyuncs.com/share-app/javaScript.jpg")
                        .content("java Script学习")
                        .build(),
                Card.builder()
                        .id(1)
                        .title("Linux学习")
                        .bgImg("http://niit-soft.oss-cn-hangzhou.aliyuncs.com/share-app/Linux.jpg")
                        .content("Linux学习")
                        .build(),
                Card.builder()
                        .id(1)
                        .title("MySql学习")
                        .bgImg("http://niit-soft.oss-cn-hangzhou.aliyuncs.com/share-app/MySql.jpg")
                        .content("SpringCloud学习")
                        .build(),
                Card.builder()
                        .id(1)
                        .title("Python学习")
                        .bgImg("http://niit-soft.oss-cn-hangzhou.aliyuncs.com/share-app/Python.jpg")
                        .content("SpringCloud学习")
                        .build(),
        };
        return Arrays.asList(cards);
    }
}
