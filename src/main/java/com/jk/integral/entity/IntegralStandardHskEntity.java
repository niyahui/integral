package com.jk.integral.entity;

import lombok.Data;

@Data
public class IntegralStandardHskEntity {
    /*积分标准表 integral_standard_hsk*/
    //主键
    private Integer integralId;
    //类别
    private Integer integralType;
    //积分标题
    private String integralHead;
    //分数
    private Integer integralGrade;
    //详细要求
    private String integralRemark;
    //可见范围
    private String integralVisualRange;
    //申请频次
    private String integralFrequency;
    //审核人
    private String integralAuditor;
    //状态
    private Integer integralState;
    /*积分类别 integral_type*/
    //主键
    private Integer typeId;
    //类别
    private String typeType;












}
