package com.jk.integral.entity;

import lombok.Data;

@Data
public class IntegralEntityNht {

    /**
     * 积分id
     */
    private Integer  id;
    /**
     *单据号
     */
    private String         number;
    /**
     *积分标题
     */
    private String  title;
    /**
     *积分数
     */
    private Integer      integral;
    /**
     *奖扣对象
     */
    private Integer user_id;
    /**
     *申请人
     */
    private String       applicant;
    /**
     *审核人
     */
    private String  reviewer;
    /**
     *审核时间
     */
    private String        examine_date;
    /**
     *申请时间
     */
    private String  apply_date;




    /**
     *排名
     */
    private Integer  paiming;
    /**
     *总积分
     */
    private Integer  zongjifen;
    /**
     *名字
     */
    private String  mingzi;
    /**
     *部门
     */
    private String  bumen;
    /**
     *职位
     */
    private String  zhiwei;
    /**
     *入职日期
     */
    private String  ruzhiriqi;




}
