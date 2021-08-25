package com.jk.integral.controller;

import com.jk.integral.entity.IntegralRequestHskEntity;
import com.jk.integral.service.IntegralRequestHskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class IntegralRequestHskController {

    @Autowired
    private IntegralRequestHskService integralRequestHskService;

    /**
     * @Author hsk
     * @Description //积分审核查询
     * @Date 10:09 2021/4/23
     * @Param [integralRequestHskEntity]
     * @return 
    **/
    @RequestMapping("getPointsAudit_HskList")
    public List<IntegralRequestHskEntity> getPointsAudit_HskList(IntegralRequestHskEntity integralRequestHskEntity){

        return integralRequestHskService.getPointsAudit_HskList(integralRequestHskEntity);
    }
    /**
     * @Author hsk
     * @Description //通过
     * @Date 10:39 2021/4/23
     * @Param [id]
     * @return
    **/
    @RequestMapping("adopt")
    public void adopt(Integer id){

        integralRequestHskService.adopt(id);
    }
    /**
     * @Author hsk
     * @Description //不通过
     * @Date 10:47 2021/4/23
     * @Param [integralRequestHskEntity]
     * @return
    **/
    @RequestMapping("no")
    public void no(IntegralRequestHskEntity integralRequestHskEntity){

        integralRequestHskService.no(integralRequestHskEntity);
    }
    /**
     * @Author hsk
     * @Description //全部通过
     * @Date 11:03 2021/4/23
     * @Param []
     * @return
    **/
    @RequestMapping("AllPassed")
    public void AllPassed(){

        integralRequestHskService.AllPassed();
    }
}
