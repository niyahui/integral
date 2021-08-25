package com.jk.integral.ControllerHHC;

import com.jk.integral.EntityHHC.JiFenEntity;
import com.jk.integral.ServiceHHC.JiFenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
public class JiFenController {


    @Autowired
    private JiFenService JiFenService;

///////////////////////////////////悬赏积分/////////////////////////////////////////////////


    /**
     * 查询个人已经领取的任务
     * @param t
     * @return
     */
    @RequestMapping("LinquRwuGet")
    public List<JiFenEntity> LinquRwuGet(JiFenEntity t, HttpServletRequest HttpServletRequest){
        return JiFenService.LinquRwuGet(t,HttpServletRequest);
    }

    /**
     * 未领取任务查询
     * @return
     */
    @RequestMapping("weiLinquRwuGet")
    public List<JiFenEntity>   weiLinquRwuGet() {
        return JiFenService.weiLinquRwuGet();
    }



    /**
     * 未领取任务查询回显
     * @return
     */
    @RequestMapping("weiLinquRwuHuixian")
    public  JiFenEntity   weiLinquRwuHuixian(Integer linqu_id) {
        return JiFenService.weiLinquRwuHuixian(linqu_id);
    }


    /**
     * 领取任务
     * @param t
     */
    @RequestMapping("linqurw")
    public  void   linqurw(JiFenEntity t,HttpSession HttpSession) {
         JiFenService.linqurw(t,HttpSession);
    }



    /**
     * 修改状态
     * @param linqu_id
     */
    @RequestMapping("tonzUser")
    public  void   tonzUser(Integer linqu_id) {
        JiFenService.tonzUser(linqu_id);
    }

////////////////////////////////////////今日积分////////////////////////////////////////////////


    /**
     * 今日积分查询
     * @param t
     * @return
     */
    @RequestMapping("jinrJiFen")
    public List<JiFenEntity> jinrJiFen(JiFenEntity t){
        return JiFenService.jinrJiFen(t);
    }


    /**
     * 今日全员总加分
     * @return
     */
    @RequestMapping("jinrJiFenzonJiaf")
    public List<JiFenEntity> jinrJiFenzonJiaf(){
        return JiFenService.jinrJiFenzonJiaf();
    }

    /**
     * 今日全员总减分
     * @return
     */
    @RequestMapping("jianrJiFenzonJiaf")
    public List<JiFenEntity> jianrJiFenzonJiaf(){
        return JiFenService.jianrJiFenzonJiaf();
    }


    /**
     * 昨天全员总加分
     * @return
     */
    @RequestMapping("ztJiFenzonJiaf")
    public List<JiFenEntity> ztJiFenzonJiaf(){
        return JiFenService.ztJiFenzonJiaf();
    }

    /**
     * 昨天全员总减分
     * @return
     */
    @RequestMapping("ztjianJiFenzonJiaf")
    public List<JiFenEntity> ztjianJiFenzonJiaf(){
        return JiFenService.ztjianJiFenzonJiaf();
    }




}