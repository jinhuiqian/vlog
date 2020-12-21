package com.jinhuiqian.vlog.service.impl;

import com.jinhuiqian.vlog.common.ResultCode;
import com.jinhuiqian.vlog.exception.CustomException;
import com.jinhuiqian.vlog.utils.DataUtil;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jinhuiqian.vlog.mapper.ArticleMapper;
import com.jinhuiqian.vlog.mapper.ArticleTagMapper;
import com.jinhuiqian.vlog.model.entity.Article;
import com.jinhuiqian.vlog.model.entity.ArticleTag;
import com.jinhuiqian.vlog.service.ArticleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDate;
import java.util.List;

/**
 * @author 231
 * @date 2020-12-15 15:35
 */
@Service
@Slf4j
public class ArticleServiceImpl implements ArticleService {
    @Resource
    private ArticleMapper articleMapper;
    @Resource
    private ArticleTagMapper articleTagMapper;

    @Override
    public void insertArticles(List<Article> articles) {
        articleMapper.insertArticles(articles);
        assert articles != null;
        articles.forEach(article -> {
            if (article.getTagList() != null) {
                articleTagMapper.insertArticleTags(article.getTagList());
            }
        });
    }

    @Override
    public PageInfo<Article> selectByPage(int pageNum, int pageSize, int userId) {
        //将参数传给这个方法就可以实现物理分页，非常简单
        PageHelper.startPage(pageNum, pageSize);
        //先根据用户id查到所有数据
        Page<Article> articlePage = articleMapper.selectAll(userId);
        //将这些数据作为入参构建出PageInfo（包含总页数，当前页码，每页数量，当前页数据list等等一堆属性和方法）
        return new PageInfo<>(articlePage);
    }

    @Override
    public Article getDetail(String id) {
        return articleMapper.getDetail(id);
    }

    @Override
    public Article postArticle(Article article) {
        article.setCover("https://picsum.photos/1920/1080?random&rand=" + Math.random());
        article.setPublishDate(LocalDate.now());
        article.setTotalWords(DataUtil.getTotalWords());
        article.setDuration(DataUtil.getDuration());
        article.setPageView(DataUtil.getPageView());
        System.out.println(article);

        int n = articleMapper.add(article);
        List<ArticleTag> tagList = article.getTagList();
        System.out.println(tagList);
        articleTagMapper.insertArticleTags(tagList);
        if(n != 0) {
            return article;
        }else {
            throw new CustomException("发表文章出错", ResultCode.DATA_IS_WRONG);
        }
    }

    @Override
    public List<Article> getRecommendArticles(int userId) {
        return articleMapper.getRecommendArticles(userId);
    }

}
