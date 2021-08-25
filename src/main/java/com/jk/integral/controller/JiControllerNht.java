package com.jk.integral.controller;


import com.jk.integral.entity.IntegralEntityNht;
import com.jk.integral.service.JiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class JiControllerNht {

    @Autowired
    private JiService  jiService;


    @RequestMapping("zong")
    @ResponseBody
    public List<IntegralEntityNht> zong(){
        return  jiService.zong();
    }
    @RequestMapping("zongmo")
    @ResponseBody
    public List<IntegralEntityNht> zongmo(){
        return  jiService.zongmo();
    }
    @RequestMapping("yue")
    @ResponseBody
    public List<IntegralEntityNht> yue(){
        return  jiService.yue();
    }
    @RequestMapping("yuemo")
    @ResponseBody
    public List<IntegralEntityNht> yuemo(){
        return  jiService.yuemo();
    }
    @RequestMapping("jin")
    @ResponseBody
    public List<IntegralEntityNht> jin(){
        return  jiService.jin();
    }
    @RequestMapping("jinmo")
    @ResponseBody
    public List<IntegralEntityNht> jinmo(){
        return  jiService.jinmo();
    }
    @RequestMapping("zongname")
    @ResponseBody
    public IntegralEntityNht zongname(){
        return  jiService.zongname();
    }
    @RequestMapping("yuename")
    @ResponseBody
    public IntegralEntityNht yuename(){
        return  jiService.yuename();
    }
    @RequestMapping("jinname")
    @ResponseBody
    public IntegralEntityNht jinname(){
        return  jiService.jinname();
    }
    @RequestMapping("zongxiang")
    @ResponseBody
    public List<IntegralEntityNht> zongxiang(){
        return  jiService.zongxiang();
    }
    @RequestMapping("zongmoxiang")
    @ResponseBody
    public List<IntegralEntityNht> zongmoxiang(){
        return  jiService.zongmoxiang();
    }
    @RequestMapping("yuexiang")
    @ResponseBody
    public List<IntegralEntityNht> yuexiang(){
        return  jiService.yuexiang();
    }
    @RequestMapping("yuemoxiang")
    @ResponseBody
    public List<IntegralEntityNht> yuemoxiang(){
        return  jiService.yuemoxiang();
    }
    @RequestMapping("jinxiang")
    @ResponseBody
    public List<IntegralEntityNht> jinxiang(){
        return  jiService.jinxiang();
    }
    @RequestMapping("jinmoxiang")
    @ResponseBody
    public List<IntegralEntityNht> jinmoxiang(){
        return  jiService.jinmoxiang();
    }
    @RequestMapping("yonghucun")
    @ResponseBody
    public void yonghucun(Integer  id, HttpServletRequest request){
        request.getSession().setAttribute("uid",id);
    }
    @RequestMapping("yonghuzong")
    @ResponseBody
    public List<IntegralEntityNht> yonghuzong(HttpServletRequest request){
       Integer id= (Integer)request.getSession().getAttribute("uid");
        return  jiService.yonghuzong(id);
    }




}
