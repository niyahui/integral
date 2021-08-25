package com.jk.integral.entity;

import lombok.Data;

import java.util.List;

@Data
public class ApplyEntity_nyh {
    private Integer apply_id;
    /**
     * 申请积分--单据号
     */
    private Long apply_document;  //申请积分--单据号
    /**
     * 申请积分--标题
     */
    private String  apply_headline; //申请积分--标题
    /**
     * 申请积分--积分
     */
    private Integer apply_integral; //申请积分--积分
    /**
     * 申请积分--奖扣对象
     */
    private String  apply_jiangkou; //申请积分--奖扣对象
    /**
     * 申请积分--审核人
     */
    private String  apply_auditor; //申请积分--审核人
    /**
     * 申请积分--状态
     */
    private Integer apply_state;  //申请积分--状态
    /**
     * 内容
     */
    private String apply_neirong;  //内容
    /**
     * 类别
     */
    private Integer apply_leibie;  //类别
    /**
     * 与用户表关联id
     */
    private Integer apply_user;  //与用户表关联id

    private Integer id;
    private String pid;
    private String text;
    private String url;
    private List<ApplyEntity_nyh> nodex;




/*------------------用户表----------------------------------------------*/
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

}
