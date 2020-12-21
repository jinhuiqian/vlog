package com.jinhuiqian.vlog.service.impl;

import com.jinhuiqian.vlog.mapper.TagMapper;
import com.jinhuiqian.vlog.model.entity.Tag;
import com.jinhuiqian.vlog.service.TagService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author 231
 * @date 2020-12-13 23:32
 */
@Service
public class TagServiceImpl implements TagService {
    @Resource
    private TagMapper tagMapper;

    @Override
    public List<Tag> selectAll() {
        return tagMapper.selectAll();
    }
}
