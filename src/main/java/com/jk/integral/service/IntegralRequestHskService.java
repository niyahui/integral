package com.jk.integral.service;

import com.jk.integral.dao.IntegralRequestHskDao;
import com.jk.integral.entity.IntegralRequestHskEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IntegralRequestHskService {

    @Autowired
    private IntegralRequestHskDao integralRequestHskDao;
    /**
     * @Author hsk
     * @Description //积分审核查询
     * @Date 10:09 2021/4/23
     * @Param [integralRequestHskEntity]
     * @return
     **/
    public List<IntegralRequestHskEntity> getPointsAudit_HskList(IntegralRequestHskEntity integralRequestHskEntity) {

        return integralRequestHskDao.getPointsAudit_HskList(integralRequestHskEntity);
    }
    /**
     * @Author hsk
     * @Description //通过
     * @Date 10:39 2021/4/23
     * @Param [id]
     * @return
     **/
    public void adopt(Integer id) {

        integralRequestHskDao.adopt(id);
    }
    /**
     * @Author hsk
     * @Description //不通过
     * @Date 10:47 2021/4/23
     * @Param [integralRequestHskEntity]
     * @return
     **/
    public void no(IntegralRequestHskEntity integralRequestHskEntity) {

        integralRequestHskDao.no(integralRequestHskEntity);
    }
    /**
     * @Author hsk
     * @Description //全部通过
     * @Date 11:03 2021/4/23
     * @Param []
     * @return
     **/
    public void AllPassed() {
        /*获取所有状态为0 */
        List<IntegralRequestHskEntity> list=integralRequestHskDao.queryAll0();
        for (IntegralRequestHskEntity integralRequestHskEntity:
             list) {
            /*全部通过*/
            integralRequestHskDao.AllPassed(integralRequestHskEntity.getIntegralReqId());
        }



    }
}
