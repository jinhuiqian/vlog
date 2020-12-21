package com.jinhuiqian.vlog.mapper;

import com.github.pagehelper.Page;
import com.jinhuiqian.vlog.model.entity.Article;
import org.apache.ibatis.annotations.*;
import java.util.List;

/**
 * @author 231
 * @date 2020-12-15 14:57
 */
public interface ArticleMapper {

    /**
     * 新增文章
     *
     * @param article 入参
     * @return int
     */
    @Insert("INSERT INTO t_article (id,category,user_id,title,cover,summary,content,publish_date,total_words,duration,page_view) " +
            "VALUES (#{article.id},#{article.category},#{article.userId},#{article.title},#{article.cover},#{article.summary},#{article.content},#{article.publishDate},#{article.totalWords},#{article.duration},#{article.pageView})")
    int add(@Param("article") Article article);

    /**
     * 批量插入文章
     *
     * @param articleList 文章集合
     * @return int
     */

    @Insert({
            "<script>",
            "INSERT INTO t_article (id,category,user_id,title,cover,summary,content,url,publish_date,total_words,duration,page_view) VALUES ",
            "<foreach collection='articleList' item='item' index='index' separator=','>",
            "(#{item.id},#{item.category},#{item.userId},#{item.title},#{item.cover},#{item.summary},#{item.content},#{item.url},#{item.publishDate},#{item.totalWords},#{item.duration},#{item.pageView})",
            "</foreach>",
            "</script>"
    })
    int insertArticles(@Param(value = "articleList") List<Article> articleList);

    /**
     *
     *
     * @param userId 用户id
     * @return 文章集合
     */
    @Select("SELECT id,category,user_id,title,cover,summary FROM t_article WHERE user_id =#{userId} ORDER BY page_view DESC LIMIT 6 ")
    @Results({
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "category", column = "category"),
            @Result(property = "userId", column = "user_id"),
            @Result(property = "title", column = "title"),
            @Result(property = "cover", column = "cover"),
            @Result(property = "summary", column = "summary")
    })
    List<Article> getRecommendArticles(@Param(value = "userId") int userId);

    @Select("SELECT id,category,user_id,title,cover,summary,publish_date FROM t_article a WHERE a.user_id = #{userId} ")
    @Results({
            @Result(id = true,property = "id", column = "id"),
            @Result(property = "category", column = "category"),
            @Result(property = "userId", column = "user_id"),
            @Result(property = "title", column = "title"),
            @Result(property = "cover", column = "cover"),
            @Result(property = "summary", column = "summary"),
            @Result(property = "publishDate", column = "publish_date"),
            @Result(property = "tagList", column = "id",
            many = @Many(select = "com.jinhuiqian.vlog.mapper.ArticleTagMapper.selectByArticleId"))
    })
    Page<Article> selectAll(@Param(value = "userId") int userId);

    @Select("SELECT * FROM t_article WHERE id = #{id}")
    @Results({
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "category",column = "category"),
            @Result(property = "userId", column = "user_id"),
            @Result(property = "title", column = "title"),
            @Result(property = "cover", column = "cover"),
            @Result(property = "content", column = "content"),
            @Result(property = "publishDate", column = "publish_date"),
            @Result(property = "totalWords", column = "total_words"),
            @Result(property = "duration", column = "duration"),
            @Result(property = "pageView", column = "page_view"),
            @Result(property = "tagList", column = "id",
                    many = @Many(select = "com.jinhuiqian.vlog.mapper.ArticleTagMapper.selectByArticleId"))
    })
    Article getDetail(@Param(value = "id") String id);
}
