package com.jk.integral.ServiceHHC;

import com.jk.integral.DaoHHC.JiFenDao;
import com.jk.integral.EntityHHC.JiFenEntity;
import com.jk.integral.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Service
public class JiFenService {

    @Autowired
  private JiFenDao JiFenDao;

    /**
     * 查询个人已经领取的任务
     * @param t
     * @return
     */
    public List<JiFenEntity> LinquRwuGet(JiFenEntity t, HttpServletRequest HttpServletRequest) {
        UserEntity user = (UserEntity) HttpServletRequest.getSession().getAttribute("user");
        return JiFenDao.LinquRwuGet(t,user.getUser_id());
    }


    /**
     * 未领取任务查询
     * @return
     */
    public List<JiFenEntity> weiLinquRwuGet() {
        return JiFenDao.weiLinquRwuGet();
    }

    /**
     * 未领取任务查询回显
     * @return
     */
    public JiFenEntity weiLinquRwuHuixian(Integer linqu_id) {
        return JiFenDao.weiLinquRwuHuixian(linqu_id);
    }

    /**
     * 领取任务
     * @param t
     */
    public void linqurw(JiFenEntity t,HttpSession HttpSession) {
        UserEntity user = (UserEntity) HttpSession.getAttribute("user");
              t.setUse_id(user.getUser_id());

        JiFenDao.linqurw(t);
    }

    /**
     * 修改状态
     * @param linqu_id
     */
    public void tonzUser(Integer linqu_id) {
        JiFenDao.tonzUser(linqu_id);
    }






    ////////////////////////////////////////今日积分////////////////////////////////////////////////

    /**
     * 今日积分查询
     * @param t
     * @return
     */
    public List<JiFenEntity> jinrJiFen(JiFenEntity t) {
        return  JiFenDao.jinrJiFen(t);
    }

    /**
     * 今日全员总加分
     * @return
     */
    public List<JiFenEntity> jinrJiFenzonJiaf() {
        return  JiFenDao.jinrJiFenzonJiaf();
    }

    /**
     * 今日全员总减分
     * @return
     */
    public List<JiFenEntity> jianrJiFenzonJiaf() {
        return  JiFenDao.jianrJiFenzonJiaf();
    }

    /**
     * 昨天全员总加分
     * @return
     */
    public List<JiFenEntity> ztJiFenzonJiaf() {
        return  JiFenDao.ztJiFenzonJiaf();
    }

    /**
     * 昨天全员总减分
     * @return
     */
    public List<JiFenEntity> ztjianJiFenzonJiaf() {
        return  JiFenDao.ztjianJiFenzonJiaf();
    }
}