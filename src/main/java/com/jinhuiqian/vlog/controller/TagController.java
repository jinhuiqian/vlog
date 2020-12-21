package com.jinhuiqian.vlog.controller;

import com.jinhuiqian.vlog.common.ResponseResult;
import com.jinhuiqian.vlog.service.TagService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author 231
 * @date 2020-12-13 23:33
 */
@RestController
@RequestMapping(value = "/api/tag")
@Slf4j
public class TagController {
    @Resource
    private TagService tagService;

    @GetMapping("all")
    public ResponseResult getTags() {
        return ResponseResult.success(tagService.selectAll());
    }
}
