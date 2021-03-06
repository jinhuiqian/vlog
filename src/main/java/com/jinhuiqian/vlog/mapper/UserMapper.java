package com.jinhuiqian.vlog.mapper;

import com.jinhuiqian.vlog.model.entity.User;
import org.apache.ibatis.annotations.*;

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

    @Insert("INSERT INTO t_user (wx_openid,phone,nickname,avatar,create_time) VALUES (#{wxOpenId},#{phone},#{nickname},#{avatar},#{createTime}) ")
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

    /**
     * 修改用户信息
     *
     * @param user 对象
     * @throws SQLException 异常
     */
    @Update("UPDATE t_user SET password=#{password},nickname=#{nickname},avatar=#{avatar},gender=#{gender},birthday=#{birthday},address=#{address}" +
            " WHERE phone=#{phone}")
    void updateUser(User user) throws SQLException;

    /**
     * 绑定手机
     *
     * @param user
     * @throws SQLException
     */
    @Update("UPDATE t_user SET phone=#{phone} WHERE wx_openid=#{wx_openid}")
    void bindPhone(User user) throws SQLException;

    /**
     * 根据微信openId查询用户信息
     *
     * @param wxOpenId 微信openId
     * @return User 用户对象
     * @throws SQLException 异常
     *
     */
    @Select({"<script>",
            "SELECT * FROM t_user ",
            "WHERE 1=1 ",
            "<when test='wxOpenId!=null'>",
            "AND wx_openid = #{wxOpenId} ",
            "</when> ",
            "</script>"})
    User fineUserByOpenId(@Param("wxOpenId") String wxOpenId) throws SQLException;

}













