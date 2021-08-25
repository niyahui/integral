package com.jk.integral.service;

import com.jk.integral.dao.WorkLogDao;
import com.jk.integral.entity.UserEntity;
import com.jk.integral.entity.WorkLogEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @ClassName workLogService
 * @Description //TODO $
 * @Date $ $
 * @Author workLogService
 * @return $
 * @Version 1.0
 **/
@Service
public class WorkLogService {

    @Autowired
    private WorkLogDao workLogDao;
    @Autowired
    private RedisTemplate redisTemplate;

    /**
     * 写工作日志
     * @param write
     */
    public void writeWorkLog(WorkLogEntity write, HttpServletRequest httpServletRequest) {
        UserEntity user = (UserEntity) httpServletRequest.getSession().getAttribute("user");
        write.setUser_id(user.getUser_id());
        Random random = new Random();
        StringBuffer sb = new StringBuffer(10);
        for (int j = 1; j <= 10; j++) {
            int i = random.nextInt(10);
            if (j == 1 || (j >= 8 && j <= 10)) {
                while (i == 0) {
                    i = random.nextInt(10);
                }
            }
            sb.append(i);
        }
        write.setNumber(sb.toString());//随机生成编号
        if (write.getVisible()==null){
            workLogDao.writeWorkLogAll(write);//全员可见
        }else {
            workLogDao.writeWorkLog(write);//设置可见权限
        }
    }
    /**
     * 查看我的日志
     * @param httpServletRequest
     * @return
     */
    public List<WorkLogEntity> lookWorkLog(HttpServletRequest httpServletRequest) {
        UserEntity user = (UserEntity) httpServletRequest.getSession().getAttribute("user");
        List<WorkLogEntity> list=workLogDao.lookWorkLog(user.getUser_id());
        return list;
    }

    /**
     * 查看对我可见的日志
     * @param httpServletRequest
     * @return
     */
    public List<WorkLogEntity> lookForMeWorkLog(WorkLogEntity work,HttpServletRequest httpServletRequest) {
        UserEntity user = (UserEntity) httpServletRequest.getSession().getAttribute("user");
        //查询所有日志
        List<WorkLogEntity> log=workLogDao.lookWorkLogAll(work);
        List<WorkLogEntity> list=new ArrayList<>();
        for (int i = 0; i <log.size(); i++) {
            if (log.get(i).getVisible()!=null){
                if (log.get(i).getVisible()==user.getUser_id());{
                    list.add(log.get(i));
                }
            }else {
                list.add(log.get(i));
            }
        }
        return list;
    }

    /**
     * 动态下拉框
     * @return
     */
    public List<UserEntity> lookForHuWorkLog() {
        return workLogDao.lookForHuWorkLog();
    }
}
