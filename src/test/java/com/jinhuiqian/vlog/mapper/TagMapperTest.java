package com.jinhuiqian.vlog.mapper;

import com.jinhuiqian.vlog.VlogApplication;
import com.jinhuiqian.vlog.model.entity.Tag;
import com.jinhuiqian.vlog.task.TagTask;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import java.util.List;
import java.util.concurrent.Future;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author 231
 * @date 2020-12-13 23:25
 */
@SpringBootTest(classes = VlogApplication.class)
class TagMapperTest {
    @Resource
    private TagTask tagTask;

    @Resource
    private TagMapper tagMapper;

    @Test
    void batchInsert() throws Exception{
        //线程池核心线程数为6，最大线程数为10，超时时间为5秒
        ThreadPoolExecutor executor = new ThreadPoolExecutor(4,8,5, TimeUnit.SECONDS,new SynchronousQueue<>());
        Future<List<Tag>> future = executor.submit(tagTask);
        List<Tag> tags = future.get();
        int count = tagMapper.insertTags(tags);
        System.out.println(count);
    }

    @Test
    void selectAll() {
        List<Tag> tags = tagMapper.selectAll();
        tags.forEach(tag -> System.out.println(tag.getTagName() + "," + tag.getTagColor()));
    }
}
