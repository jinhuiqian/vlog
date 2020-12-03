package com.jinhuiqian.vlog.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 231
 * @date 2020-12-03 14:19
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Card {
    private Integer id;
    private String title;
    private String bgImg;
    private String content;
}
