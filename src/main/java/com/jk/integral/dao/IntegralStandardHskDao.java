package com.jk.integral.dao;

import com.jk.integral.entity.IntegralStandardHskEntity;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface IntegralStandardHskDao {
    /**
     * @Author hsk
     * @Description //积分标准
     * @Date 20:04 2021/4/21
     * @Param [integral]
     * @return
    **/
    List<IntegralStandardHskEntity> getIntegralSettingStandardList(IntegralStandardHskEntity integral);
    /**
     * @Author hsk
     * @Description //类别动态查询
     * @Date 9:45 2021/4/22
     * @Param []
     * @return
    **/
    List<IntegralStandardHskEntity> getType();
    /**
     * @Author hsk
     * @Description //新增积分标准
     * @Date 10:06 2021/4/22
     * @Param [integral]
     * @return
    **/
    void addIntegralStandardHsk(IntegralStandardHskEntity integral);
    /**
     * @Author hsk
     * @Description //积分标准删除
     * @Date 10:38 2021/4/22
     * @Param [id]
     * @return
     **/
    void delIntegralSettingStandard(Integer id);
    /**
     * @Author hsk
     * @Description //积分标准回显
     * @Date 11:07 2021/4/22
     * @Param [id]
     * @return
     **/
    IntegralStandardHskEntity getIntegralSettingStandardHui(Integer id);
    /**
     * @Author hsk
     * @Description //积分标准修改
     * @Date 14:11 2021/4/22
     * @Param [integral]
     * @return
     **/
    void updateIntegralSettingStandard(IntegralStandardHskEntity integral);
    /**
     * @Author hsk
     * @Description //查询需要导出的数据
     * @Date 14:07 2021/4/22
     * @Param []
     * @return
     **/
    List<IntegralStandardHskEntity> query();
    /**
     * @Author hsk
     * @Description //批量修改类别
     * @Date 15:11 2021/4/22
     * @Param [id, addid]
     * @return
    **/
    void updateAll(@Param("id") String id,@Param("addid") Integer addid);
    /**
     * @Author hsk
     * @Description //暂停
     * @Date 15:20 2021/4/22
     * @Param [id]
     * @return
     **/
    void suspendIntegralSettingStandard(Integer id);
    /**
     * @Author hsk
     * @Description //积分类别管理-查询
     * @Date 15:40 2021/4/22
     * @Param []
     * @return
     *
     * @param integralStandardHskEntity*/
    List<IntegralStandardHskEntity> getclassificationOfIntegralStandardList(IntegralStandardHskEntity integralStandardHskEntity);

    /*/////积分类别管理//////////////////////////积分类别管理//////////////////////积分类别管理////////////////////////////////////////*/
    /**
     * @Author hsk
     * @Description //积分类别管理-增加
     * @Date 16:11 2021/4/22
     * @Param [integralStandardHskEntity]
     * @return
     **/
    void addclassificationOfIntegralStandard(IntegralStandardHskEntity integralStandardHskEntity);
    /**
     * @Author hsk
     * @Description //T积分类别管理回显
     * @Date 16:19 2021/4/22
     * @Param [id]
     * @return
     **/
    IntegralStandardHskEntity gettypeTypeId(Integer id);
    /**
     * @Author hsk
     * @Description //T积分类别管理修改
     * @Date 16:19 2021/4/22
     * @Param [id]
     * @return
     **/
    void updateClassificationOfIntegralStandard(IntegralStandardHskEntity integralStandardHskEntity);
    /**
     * @Author hsk
     * @Description //积分类别管理删除
     * @Date 16:45 2021/4/22
     * @Param [id]
     * @return
     **/
    void deltypeType(Integer id);
    /**
     * @Author hsk
     * @Description ///*已暂停的标准-查询
     * @Date 16:50 2021/4/22
     * @Param [Integral]
     * @return
     **/
    List<IntegralStandardHskEntity> getSuspendedStandardsList(IntegralStandardHskEntity integral);

    void recovery(Integer id);
}
