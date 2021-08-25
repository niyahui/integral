package com.jk.integral.controller;

import com.jk.integral.entity.IntegralStandardHskEntity;
import com.jk.integral.service.IntegralStandardHskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @Author hsk
 * @Description //积分标准
 * @Date 17:58 2021/4/21
 * @Param 
 * @return 
**/
@RestController
public class IntegralStandardHskController {

    @Autowired
    private IntegralStandardHskService integralStandardHskService;

    /**
     * @Author hsk
     * @Description //积分标准查询
     * @Date 9:43 2021/4/22
     * @Param [Integral]
     * @return
    **/
    @RequestMapping("getIntegralSettingStandardList")
    public List<IntegralStandardHskEntity> getIntegralSettingStandardList(IntegralStandardHskEntity Integral){

        return integralStandardHskService.getIntegralSettingStandardList(Integral);
    }
    /**
     * @Author hsk
     * @Description //类别动态查询
     * @Date 9:44 2021/4/22
     * @Param []
     * @return
    **/
    @RequestMapping("getType")
    public List<IntegralStandardHskEntity> getType(){

        return integralStandardHskService.getType();
    }
    /**
     * @Author hsk
     * @Description //增加积分标准
     * @Date 10:05 2021/4/22
     * @Param [Integral]
     * @return
    **/
    @RequestMapping("addIntegralStandardHsk")
    public void addIntegralStandardHsk(IntegralStandardHskEntity Integral){

        integralStandardHskService.addIntegralStandardHsk(Integral);
    }
    /**
     * @Author hsk
     * @Description //积分标准删除
     * @Date 10:38 2021/4/22
     * @Param [id]
     * @return
    **/
    @RequestMapping("delIntegralSettingStandard")
    public void delIntegralSettingStandard(Integer id){

        integralStandardHskService.delIntegralSettingStandard(id);
    }
    /**
     * @Author hsk
     * @Description //积分标准回显
     * @Date 11:07 2021/4/22
     * @Param [id]
     * @return
    **/
    @RequestMapping("getIntegralSettingStandardHui")
    public IntegralStandardHskEntity getIntegralSettingStandardHui(Integer id){

        return integralStandardHskService.getIntegralSettingStandardHui(id);
    }
    /**
     * @Author hsk
     * @Description //积分标准回显
     * @Date 14:11 2021/4/22
     * @Param [integral]
     * @return
    **/
    @RequestMapping("updateIntegralSettingStandard")
    public void updateIntegralSettingStandard(IntegralStandardHskEntity integral){

        integralStandardHskService.updateIntegralSettingStandard(integral);
    }
    /**
     * @Author hsk
     * @Description //导出
     * @Date 14:05 2021/4/22
     * @Param [request, response]
     * @return
    **/
    @RequestMapping("exportData")
    public void exportDate(HttpServletRequest request, HttpServletResponse response){

        integralStandardHskService.exportDate(request,response);
    }
    /**
     * @Author hsk
     * @Description //批量修改类别
     * @Date 15:06 2021/4/22
     * @Param []
     * @return
    **/
    @RequestMapping("updateAll")
    public void updateAll(String[] ids,Integer addid){

        integralStandardHskService.updateAll(ids,addid);
    }
    /**
     * @Author hsk
     * @Description //暂停
     * @Date 15:20 2021/4/22
     * @Param [id]
     * @return
    **/
    @RequestMapping("suspendIntegralSettingStandard")
    public void suspendIntegralSettingStandard(Integer id){

        integralStandardHskService.suspendIntegralSettingStandard(id);
    }
    /*/////积分类别管理//////////////////////////积分类别管理//////////////////////积分类别管理////////////////////////////////////////*/
    /**
     * @Author hsk
     * @Description //积分类别管理-查询
     * @Date 15:40 2021/4/22
     * @Param []
     * @return
    **/
    @RequestMapping("getclassificationOfIntegralStandardList")
    public List<IntegralStandardHskEntity> getclassificationOfIntegralStandardList(IntegralStandardHskEntity IntegralStandardHskEntity){

        return integralStandardHskService.getclassificationOfIntegralStandardList(IntegralStandardHskEntity);
    }
    /**
     * @Author hsk
     * @Description //积分类别管理-增加-修改
     * @Date 16:11 2021/4/22
     * @Param [integralStandardHskEntity]
     * @return
    **/
    @RequestMapping("addclassificationOfIntegralStandard")
    public void addclassificationOfIntegralStandard(IntegralStandardHskEntity integralStandardHskEntity){

        if(integralStandardHskEntity.getTypeId()==null){
            integralStandardHskService.addclassificationOfIntegralStandard(integralStandardHskEntity);
        }else{
            integralStandardHskService.updateClassificationOfIntegralStandard(integralStandardHskEntity);
        }


    }
    /**
     * @Author hsk
     * @Description //T积分类别管理回显
     * @Date 16:21 2021/4/22
     * @Param [id]
     * @return 
    **/
    @RequestMapping("gettypeTypeId")
    public IntegralStandardHskEntity gettypeTypeId(Integer id){

        return integralStandardHskService.gettypeTypeId(id);
    }
    /**
     * @Author hsk
     * @Description //积分类别管理删除
     * @Date 16:45 2021/4/22
     * @Param [id]
     * @return
    **/
    @RequestMapping("deltypeType")
    public void deltypeType(Integer id){

        integralStandardHskService.deltypeType(id);
    }
    /**
     * @Author hsk
     * @Description ///*已暂停的标准-查询
     * @Date 16:50 2021/4/22
     * @Param [Integral]
     * @return
    **/
    @RequestMapping("getSuspendedStandardsList")
    public List<IntegralStandardHskEntity> getSuspendedStandardsList(IntegralStandardHskEntity Integral){

        return integralStandardHskService.getSuspendedStandardsList(Integral);
    }
    @RequestMapping("recovery")
    public void recovery(Integer id){

        integralStandardHskService.recovery(id);
    }


}
