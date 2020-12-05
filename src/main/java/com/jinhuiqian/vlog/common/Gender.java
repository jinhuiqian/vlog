package com.jinhuiqian.vlog.common;


/**
 * @author 231
 * @date 2020-12-05 13:08
 */

public enum Gender {

    /**
     * 枚举
     */
    secret(0,"保密"),
    male(1,"男"),
    female(2,"女");


    public final Integer type;
    public final String value;

    Gender(Integer type, String value){
        this.type = type;
        this.value = value;
    }
}
