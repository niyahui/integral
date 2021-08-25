package com.jk.integral.controller;

import com.jk.integral.entity.Missionhall_fwt;
import com.jk.integral.entity.UserEntity;
import com.jk.integral.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class UserController {

        @Autowired
        private UserService userService;



        /**
         * 登录
         * @param
         * @param request
         * @return
         */
        //登录判断
        @RequestMapping("login")  //这里就是登录页面请求的地址
        @ResponseBody
        public Map login(  UserEntity t, HttpServletRequest request){  //注意返回的 是 Map 的返回值
                return userService.login(t,request);  //把实体类  和 工具栏需要的 属性给传到业务处理层
        }

        //个人资料回显
        public UserEntity getById(Integer id){
                return userService.getById(id);
        }
        //修改
        public void update(UserEntity userEntity){
                userService.update(userEntity);
        }


        @RequestMapping("/")
        public String lonin(){
                return "login.html";
        }


        @RequestMapping("select1")
        @ResponseBody
        public Missionhall_fwt select1(){
                Integer id=1;
                return userService.select1(id);
        }

        @RequestMapping("update1")
        @ResponseBody
        public void update1(){
                Integer id=1;
                userService.update1(id);
        }

        @RequestMapping("jia")
        @ResponseBody
        public void jia(Missionhall_fwt missionhall_fwt){
                missionhall_fwt.setUserid(1);

                userService.jia(missionhall_fwt);
        }

        @RequestMapping("unfinished")
        public void unfinished(Missionhall_fwt missionhall_fwt){
                missionhall_fwt.setUserid(1);
                userService.unfinished(missionhall_fwt);
        }

        @RequestMapping("wancheng")
        public void wancheng(Missionhall_fwt missionhall_fwt){
                userService.wancheng(missionhall_fwt);
        }
}
