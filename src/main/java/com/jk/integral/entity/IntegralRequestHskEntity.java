package com.jk.integral.entity;

import lombok.Data;

@Data
public class IntegralRequestHskEntity {

    /*积分审核表 integral_request_hsk*/
    /**
     * @Author hsk
     * @Description //编号
     * @Date 9:49 2021/4/23
     * @Param 
     * @return 
    **/
    private Integer integralReqId;
    /**
     * @Author hsk
     * @Description //奖扣对象
     * @Date 9:49 2021/4/23
     * @Param 
     * @return 
    **/
    private String integraPrizeBuckObject;
    /**
     * @Author hsk
     * @Description //所在部门
     * @Date 9:49 2021/4/23
     * @Param 
     * @return 
    **/
    private String integraDepartment;
    /**
     * @Author hsk
     * @Description //申请人员
     * @Date 9:50 2021/4/23
     * @Param 
     * @return 
    **/
    private String integraApplyForPersonne;
    /**
     * @Author hsk
     * @Description //申请分数
     * @Date 9:50 2021/4/23
     * @Param 
     * @return 
    **/
    private Integer integralGrade;
    /**
     * @Author hsk
     * @Description //申请时间
     * @Date 9:50 2021/4/23
     * @Param 
     * @return 
    **/
    private String integraDateTime;
    /**
     * @Author hsk
     * @Description //单据号
     * @Date 9:50 2021/4/23
     * @Param 
     * @return 
    **/
    private String integraDocumentNumber;
    /**
     * @Author hsk
     * @Description //申请内容
     * @Date 9:50 2021/4/23
     * @Param 
     * @return 
    **/
    private String integralHead;
    /**
     * @Author hsk
     * @Description //状态 0普通    1  通过 2 不通过
     * @Date 9:50 2021/4/23
     * @Param 
     * @return 
    **/
    private Integer inetegraState;
    /**
     * @Author hsk
     * @Description //不通过 理由
     * @Date 10:00 2021/4/23
     * @Param
     * @return
    **/
    private String integraReasonsForFailure;

}
