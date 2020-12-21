package com.jinhuiqian.vlog.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @author 231
 * @date 2020-12-15 13:49
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Article {
    private String id;
    private String category;
    private Integer userId;
    private String title;
    private String cover;
    private String summary;
    private String content;
    private String url;
    private LocalDateTime publishDate;
    private String totalWords;
    private Integer duration;
    private Integer pageView;
    private List<ArticleTag> tagList;
}
