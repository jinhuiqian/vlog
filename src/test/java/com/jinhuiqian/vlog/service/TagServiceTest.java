package com.jinhuiqian.vlog.service;

import com.jinhuiqian.vlog.VlogApplication;
import com.jinhuiqian.vlog.model.entity.Tag;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author 231
 * @date 2020-12-20 12:04
 */
@SpringBootTest(classes = VlogApplication.class)
@Slf4j
class TagServiceTest {
    @Resource
    private TagService tagService;

    @Test
    void selectAll() {
        Tag tag = new Tag(1,"ds","ds");
        List<Tag> tagList = new ArrayList<>(100);
        tagList.add(tag);
        System.out.println(tagList);
    }
}
