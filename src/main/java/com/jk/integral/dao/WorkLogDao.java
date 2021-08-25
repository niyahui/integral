package com.jk.integral.dao;

import com.jk.integral.entity.UserEntity;
import com.jk.integral.entity.WorkLogEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @ClassName workLogDao
 * @Description //TODO $
 * @Date $ $
 * @Author workLogDao
 * @return $
 * @Version 1.0
 **/
@Repository
public interface WorkLogDao {
    /**
     * 写工作日志
     * @param write
     */
    void writeWorkLog(WorkLogEntity write);
    /**
     * 写工作日志--全员可见
     * @param write
     */
    void writeWorkLogAll(WorkLogEntity write);
    /**
     * 查看我的日志
     * @param user_id
     * @return
     */
    List<WorkLogEntity> lookWorkLog(Integer user_id);

    /**
     * 查询全部日志
     * @return
     */
    List<WorkLogEntity> lookWorkLogAll(WorkLogEntity work);

    /**
     * 动态下拉框
     * @return
     */
    List<UserEntity> lookForHuWorkLog();
}
