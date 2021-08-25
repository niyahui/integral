package com.jk.integral.DaoHHC;

import com.jk.integral.EntityHHC.JiFenEntity;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JiFenDao {

    /**
     * 查询个人已经领取的任务
     * @param t
     * @return
     */
    List<JiFenEntity> LinquRwuGet(@Param("t")  JiFenEntity t, @Param("user_id")Integer user_id);

    /**
     * 未领取任务查询
     * @return
     */
    List<JiFenEntity> weiLinquRwuGet();

    /**
     * 未领取任务查询回显
     * @return
     */
    JiFenEntity weiLinquRwuHuixian(Integer linqu_id);


    /**
     * 领取任务
     * @param t
     */
    void linqurw(JiFenEntity t);

    /**
     * 修改状态
     * @param linqu_id
     */
    void tonzUser(Integer linqu_id);


    ////////////////////////////////////////今日积分////////////////////////////////////////////////

    /**
     * 今日积分查询
     * @param t
     * @return
     */
    List<JiFenEntity> jinrJiFen(JiFenEntity t);

    /**
     * 今日全员总加分
     * @return
     */
    List<JiFenEntity> jinrJiFenzonJiaf();

    /**
     * 今日全员总减分
     * @return
     */
    List<JiFenEntity> jianrJiFenzonJiaf();

    /**
     * 昨天全员总加分
     * @return
     */
    List<JiFenEntity> ztJiFenzonJiaf();

    /**
     * 昨天全员总减分
     * @return
     */
    List<JiFenEntity> ztjianJiFenzonJiaf();
}
