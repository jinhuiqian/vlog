package com.jinhuiqian.vlog.mapper;

import com.jinhuiqian.vlog.model.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.sql.SQLException;

/**
 * @author 231
 * @date 2020-12-05 14:05
 */
public interface UserMapper {
    /**
     *
     * @param user 入参user对象
     * @throws SQLException 异常
     */

    @Insert("INSERT INTO t_user (phone,password,nickname,avatar,gender,birthday,address,create_time)" +
            "VALUES (#{phone},#{password},#{nickname},#{avatar},#{gender},#{birthday},#{address},#{createTime}) ")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void insert(User user) throws SQLException;

    /**
     * @param phone 手机号
     * @return User 用户对象
     * @throws SQLException 异常
     */

    @Select({"<script>",
            "SELECT * FROM t_user ",
            "WHERE 1=1 ",
            "<when test='phone!=null'> ",
            "AND phone = #{phone} ",
            "</when> ",
            "</script>"})
    User findUserByPhone(@Param("phone") String phone) throws SQLException;
}













