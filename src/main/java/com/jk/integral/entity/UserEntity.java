package com.jk.integral.entity;

import lombok.Data;

/**
 * @ClassName UserEntity
 * @Description //TODO $
 * @Date $ $
 * @Author UserEntity
 * @return $
 * @Version 1.0
 * 表名：t_user
 **/
@Data
public class UserEntity {
    /**
     * 用户id
     */
    private Integer user_id;
    /**
     * 用户名
     */
    private String user_name;
    /**
     * 账号
     */
    private Integer user_num;
    /**
     *密码
     */
    private String user_password;
    /**
     *性别
     */
    private String user_sex;
    /**
     *入职时间
     */
    private String user_date;
    /**
     *照片
     */
    private String user_img;
    /**
     *头像
     */
    private String user_headportrait;
    /**
     *部门分
     */
    private Integer division;
    /**
     *职位分
     */
    private Integer positionpoints;
    /**
     *学历分
     */
    private Integer educationscore;
    /**
     *职称分
     */
    private Integer titlescore;
    /**
     *部门id
     */
    private Integer department_id;
    /**
     *职位id
     */
    private Integer position_id;
    /**
     * 积分关联id
     */
    private Integer integral_id;
    /*------------------------------------------------------------------------------*/
    /**
     * 部门id
     */
    private Integer  id;
    /**
     * 部门名字
     */
    private String   name;

/*------------------------------------------------------------------------------*/
    /**
     * 积分id
     */
    private Integer integral;
}
