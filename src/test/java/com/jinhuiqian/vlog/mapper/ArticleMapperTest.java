package com.jinhuiqian.vlog.mapper;

import com.github.pagehelper.Page;
import com.jinhuiqian.vlog.VlogApplication;
import com.jinhuiqian.vlog.model.entity.Article;
import com.jinhuiqian.vlog.task.ArticleTask;
import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.util.threads.ThreadPoolExecutor;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import java.util.List;
import java.util.concurrent.Future;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

/**
 * @author 231
 * @date 2020-12-15 15:07
 */
@SpringBootTest(classes = VlogApplication.class)
@Slf4j
class ArticleMapperTest {
    @Resource
    private ArticleMapper articleMapper;
    @Resource
    private ArticleTask articleTask;

    @Test
    void insertArticles() throws Exception{
        ThreadPoolExecutor executor = new ThreadPoolExecutor(4,8,5,
                TimeUnit.SECONDS,new SynchronousQueue<>());
        Future<List<Article>> future = executor.submit(articleTask);
        List<Article> articles = future.get();
        int count = articleMapper.insertArticles(articles);
        System.out.println(count);
    }

    @Test
    void selectAll() {
        Page<Article> articlePage = articleMapper.selectAll(1);
        System.out.println(articlePage.toPageInfo().getList().size());
    }
}
