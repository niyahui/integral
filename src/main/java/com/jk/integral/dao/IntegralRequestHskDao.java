package com.jk.integral.dao;

import com.jk.integral.entity.IntegralRequestHskEntity;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface IntegralRequestHskDao {
    /**
     * @Author hsk
     * @Description //积分审核查询
     * @Date 10:09 2021/4/23
     * @Param [integralRequestHskEntity]
     * @return
     **/
    List<IntegralRequestHskEntity> getPointsAudit_HskList(IntegralRequestHskEntity integralRequestHskEntity);
    /**
     * @Author hsk
     * @Description //通过
     * @Date 10:39 2021/4/23
     * @Param [id]
     * @return
     **/
    void adopt(Integer id);
    /**
     * @Author hsk
     * @Description //不通过
     * @Date 10:47 2021/4/23
     * @Param [integralRequestHskEntity]
     * @return
     **/
    void no(IntegralRequestHskEntity integralRequestHskEntity);
    /*获取所有状态为0 */
    List<IntegralRequestHskEntity> queryAll0();
    /**
     * @Author hsk
     * @Description //全部通过
     * @Date 11:03 2021/4/23
     * @Param []
     * @return
     **/
    void AllPassed(Integer integralReqId);
}
