package com.jk.integral.service;

import com.jk.integral.dao.UserDao;
import com.jk.integral.entity.Missionhall_fwt;
import com.jk.integral.entity.UserEntity;
import com.jk.integral.utils.ReturnMsgUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@Service
public class UserService {

    @Autowired
    private UserDao userDao;



    public UserEntity getById(Integer id) {
        return userDao.getById(id);
    }

    public void update(UserEntity userEntity) {
         userDao.userEntity(userEntity);
    }

    public Map login(UserEntity t, HttpServletRequest request) {
        if(t.getUser_num()== null  || "".equals(t.getUser_num())){
            return   ReturnMsgUtils.returnMsg(250, "账号为空", null);
        }
//		判断密码为空
        if(t.getUser_password()== null  || "".equals(t.getUser_password())){
            return ReturnMsgUtils.returnMsg(251, "密码为空", null);
        }


            //查询是是否存在
            UserEntity user = userDao.UserEntity(t);
            if(user == null){
                return ReturnMsgUtils.returnMsg(2002, "账号或者密码错误", null);
            }else{
                request.getSession().setAttribute("user",user);
                return ReturnMsgUtils.returnMsg(200, "登录成功", user);
            }

    }

    public Missionhall_fwt select1(Integer id) {
        return  userDao.select1(id);
    }

    public void update1(Integer id) {
        Integer xiao=userDao.chaxiao1(id);
        userDao.update1(id,xiao);
    }

    public void jia(Missionhall_fwt missionhall_fwt) {
        userDao.jia(missionhall_fwt);
    }

    public void unfinished(Missionhall_fwt missionhall_fwt) {
        userDao.unfinished(missionhall_fwt);
    }

    public void wancheng(Missionhall_fwt missionhall_fwt) {
        userDao.wancheng(missionhall_fwt);
    }
}

