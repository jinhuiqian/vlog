package com.jinhuiqian.vlog.mapper;

import com.jinhuiqian.vlog.model.entity.Tag;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import javax.sound.midi.Track;
import java.util.List;

/**
 * @author 231
 * @date 2020-12-13 23:18
 */
public interface TagMapper {

    @Insert({
            "<script>",
            "INSERT INTO t_tag(tag_name, tag_color) VALUES ",
            "<foreach collection='tagList' item='item' index='index' separator=','>",
            "(#{item.tagName}, #{item.tagColor})",
            "</foreach>",
            "</script>"
    })
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insertTags(@Param(value = "tagList") List<Tag> tagList);

    /**
     *
     * @return List<Tag>
     */
    @Select("SELECT * FROM t_tag ")
    List<Tag> selectAll();
}
