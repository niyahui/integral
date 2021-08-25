package com.jk.integral.controller;

import com.jk.integral.entity.UserEntity;
import com.jk.integral.entity.WorkLogEntity;
import com.jk.integral.service.WorkLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @ClassName workLogController
 * @Description //TODO $
 * @Date $ $
 * @Author workLogController
 * @return $
 * @Version 1.0
 **/
@Controller
public class WorkLogController {

    @Autowired
    private WorkLogService workLogService;

    /**
     * 写工作日志
     */
    @RequestMapping("writeWorkLog")
    @ResponseBody
    public void writeWorkLog(WorkLogEntity write, HttpServletRequest httpServletRequest){
        workLogService.writeWorkLog(write,httpServletRequest);
    }

    /**
     * 查看我的日志
     * @param httpServletRequest
     * @return
     */
    @RequestMapping("getMyWorkLogList")
    @ResponseBody
    public List<WorkLogEntity> lookWorkLog(HttpServletRequest httpServletRequest){
        return workLogService.lookWorkLog(httpServletRequest);
    }

    /**
     * 查看对我可见的日志
     * @param httpServletRequest
     * @return
     */
    @RequestMapping("lookForMeWorkLog")
    @ResponseBody
    public List<WorkLogEntity> lookForMeWorkLog(WorkLogEntity work,HttpServletRequest httpServletRequest){
        return workLogService.lookForMeWorkLog(work,httpServletRequest);
    }

    /**
     * 动态下拉框
     * @return
     */
    @RequestMapping("lookForHuWorkLog")
    @ResponseBody
    public List<UserEntity> lookForHuWorkLog(){
        return workLogService.lookForHuWorkLog();
    }







}
