package com.jinhuiqian.vlog.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 231
 * @date 2020-12-15 13:53
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ArticleTag {
    private Integer id;
    private String articleId;
    private String tagName;
}
