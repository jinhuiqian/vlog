package com.jinhuiqian.vlog.mapper;

import com.jinhuiqian.vlog.model.entity.ArticleTag;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author 231
 * @date 2020-12-15 15:20
 */
public interface ArticleTagMapper {

    /**
     * 批量插入
     *
     * @param articleTagList 集合
     */
    @Insert({
            "<script>",
            "INSERT INTO t_article_tag (article_id,tag_name) VALUES ",
            "<foreach collection='articleTagList' item='item' index='index' separator=','>",
            "(#{item.articleId},#{item.tagName})",
            "</foreach>",
            "</script>"
    })
    void insertArticleTags(@Param(value = "articleTagList") List<ArticleTag> articleTagList);

    /**
     * 查询指定文章的所有标签
     *
     * @param articleId 文章id
     * return List<ArticleTag>
     */
    @Select("SELECT * FROM t_article_tag WHERE article_id = #{articleId}")
    List<ArticleTag> selectByArticleId(@Param(value = "articleId") String articleId);
}
