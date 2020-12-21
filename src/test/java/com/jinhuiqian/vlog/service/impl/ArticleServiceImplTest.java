package com.jinhuiqian.vlog.service.impl;

import com.github.pagehelper.PageInfo;
import com.jinhuiqian.vlog.VlogApplication;
import com.jinhuiqian.vlog.mapper.ArticleMapper;
import com.jinhuiqian.vlog.model.entity.Article;
import com.jinhuiqian.vlog.service.ArticleService;
import com.jinhuiqian.vlog.task.ArticleTask;
import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.util.threads.ThreadPoolExecutor;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.sql.SQLOutput;
import java.util.List;
import java.util.concurrent.*;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author 231
 * @date 2020-12-15 15:48
 */
@SpringBootTest(classes = VlogApplication.class)
@Slf4j
class ArticleServiceImplTest {
    @Resource
    private ArticleService articleService;
    @Resource
    private ArticleTask articleTask;

    @Test
    void insertArticles() throws Exception{
        ThreadPoolExecutor executor = new ThreadPoolExecutor(4,8,5,
                TimeUnit.SECONDS,new LinkedBlockingDeque<>(), Executors.defaultThreadFactory(),new ThreadPoolExecutor.AbortPolicy());
        Future<List<Article>> future = executor.submit(articleTask);
        List<Article> articles = null;
        articles = future.get();
        articleService.insertArticles(articles);
    }

    @Test
    void selectByPage() {
        PageInfo<Article> articlePageInfo = articleService.selectByPage(1,9,1);
        System.out.println(articlePageInfo.getList().size());
    }

    @Test
    void getRecommend() {
        List<Article> recommendAriticles = articleService.getRecommendArticles(1);
        recommendAriticles.forEach(System.out::println);
    }

    @Test
    void getDetail() {
        Article detail = articleService.getDetail("090fae3b8aa84adb8af4e92a11773cde");
        System.out.println(detail);
    }
}
