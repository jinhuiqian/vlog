package com.jinhuiqian.vlog.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 231
 * @date 2020-12-03 12:37
 */
@RestController
@RequestMapping(value = "api")
public class HelloController {

    @GetMapping("hello")
    public String hello(){
        return "hello spring boot";
    }
}
