package com.jinhuiqian.vlog.service;

import com.jinhuiqian.vlog.model.entity.Tag;

import java.util.List;

/**
 * @author 231
 * @date 2020-12-13 23:31
 */
public interface TagService {
    /**
     * 查询所有标签
     *
     * @return List<Tag>
     */
    List<Tag> selectAll();
}
