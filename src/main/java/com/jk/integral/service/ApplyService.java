package com.jk.integral.service;

import com.jk.integral.dao.ApplyDao;
import com.jk.integral.entity.ApplyEntity_nyh;
import com.jk.integral.entity.IntegralStandardHskEntity;
import com.jk.integral.entity.UserEntity;
import com.jk.integral.utils.SnowflakeIdWorker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
@Service
public class ApplyService {

    @Autowired
    private ApplyDao applyDao;

    /**
     * 选择标准查询列表
     * @return
     */
    public List<ApplyEntity_nyh> apply1() {
        List<ApplyEntity_nyh> list=applyDao.apply();
        return list;
    }
    public List<ApplyEntity_nyh> apply(Integer id) {
        List<ApplyEntity_nyh> list=applyDao.apply1(id);
        return list;
    }

    public List<ApplyEntity_nyh> leibie(Integer pid) {
        List<ApplyEntity_nyh> list=applyDao.leibie(pid);
        return list;
    }

    /**
     * 填写申请
     * @param applyEntity_nyh
     */
    public void applyadd(ApplyEntity_nyh applyEntity_nyh,HttpServletRequest request) {
        ApplyEntity_nyh list = (ApplyEntity_nyh) request.getSession().getAttribute("list");
        SnowflakeIdWorker sf = new SnowflakeIdWorker();
        long l = sf.nextId();
        if (applyEntity_nyh.getApply_integral()==null){
            applyEntity_nyh.setApply_integral(0);
        }else {
            applyEntity_nyh.setApply_integral(applyEntity_nyh.getApply_integral());
        }
        applyEntity_nyh.setApply_document(l);
        applyEntity_nyh.setApply_state(1);
        if (list==null){
            applyEntity_nyh.setApply_leibie(1);
            applyEntity_nyh.setApply_user(1);
        }else{
            applyEntity_nyh.setApply_leibie(list.getApply_leibie());
            applyEntity_nyh.setApply_user(list.getApply_user());
            applyEntity_nyh.setApply_jiangkou(list.getUser_name());
        }
        applyDao.applyadd(applyEntity_nyh);
    }

    /**
     * 撤销
     * @param id
     */
    public void chexiao(Integer id) {
        applyDao.chexiao(id);
    }

    /**
     * 填写申请回显
     * @return
     */
    public ApplyEntity_nyh gethui(HttpServletRequest request) {
        Integer id = (Integer) request.getSession().getAttribute("id");
        ApplyEntity_nyh list=applyDao.gethui(id);
        request.getSession().setAttribute("list",list);
        return  list;
    }

    /**
     * 申请成功查询
     * @return
     */
    public List<ApplyEntity_nyh> applycha() {
        return  applyDao.applycha();
    }

    /**
     * 回显查询id
     * @param id
     * @return
     */
    public List<ApplyEntity_nyh> applyup(Integer id, HttpServletRequest request) {
        List<ApplyEntity_nyh> list=applyDao.applyup(id);
        request.getSession().setAttribute("id",id);
        return  list;
    }
    /**
     * 积分PK
     * @return
     */
    public List<UserEntity> jifenpk() {
        List<UserEntity> list=applyDao.jifenpk();
        return list;
    }
    public List<UserEntity> jifenpk2() {
        List<UserEntity> list=applyDao.jifenpk2();
        return list;
    }
    public List<UserEntity> jifenpk3() {
        List<UserEntity> list=applyDao.jifenpk3();
        return list;
    }
    /**
     * 积分PK 平均分查询
     * @return
     */
    public Integer pingjunfen() {
        List<UserEntity> list=applyDao.pingjunfen();
        Integer pingjun=0;
        for (int i = 0; i < list.size(); i++) {
            pingjun+=list.get(i).getIntegral();
        }

        return pingjun;
    }
    public Integer pingjunfen1() {
        List<UserEntity> list=applyDao.pingjunfen1();
        Integer pingjun=0;
        for (int i = 0; i < list.size(); i++) {
            pingjun+=list.get(i).getIntegral();
        }

        return pingjun;
    }
    public Integer pingjunfen2() {
        List<UserEntity> list=applyDao.pingjunfen2();
        Integer pingjun=0;
        for (int i = 0; i < list.size(); i++) {
            pingjun+=list.get(i).getIntegral();
        }

        return pingjun;
    }

    /**
     * 排名
     * @return
     */
    public String puanduan() {
        List<UserEntity> list=applyDao.pingjunfen();
        List<UserEntity> list1=applyDao.pingjunfen1();
        List<UserEntity> list2=applyDao.pingjunfen2();
        Integer pingjun=0;
        Integer pingjun1=0;
        Integer pingjun2=0;
        String  ddd="";
        for (int i = 0; i < list.size(); i++) {
            pingjun+=list.get(i).getIntegral();
        }
        for (int i = 0; i < list1.size(); i++) {
            pingjun1+=list1.get(i).getIntegral();
        }
        for (int i = 0; i < list2.size(); i++) {
            pingjun2+=list2.get(i).getIntegral();
        }
        if (pingjun<pingjun1 && pingjun<pingjun2){
            ddd="季军";
        }else if(pingjun>pingjun1 && pingjun<pingjun2){
            ddd="亚军";
        }else if(pingjun>pingjun2 && pingjun<pingjun1){
            ddd="亚军";
        }else if(pingjun>pingjun2 && pingjun>pingjun1){
            ddd="冠军";
        }
        return ddd;
    }
    public String puanduan1() {
        List<UserEntity> list=applyDao.pingjunfen();
        List<UserEntity> list1=applyDao.pingjunfen1();
        List<UserEntity> list2=applyDao.pingjunfen2();
        Integer pingjun=0;
        Integer pingjun1=0;
        Integer pingjun2=0;
        String  ddd="";
        for (int i = 0; i < list.size(); i++) {
            pingjun+=list.get(i).getIntegral();
        }
        for (int i = 0; i < list1.size(); i++) {
            pingjun1+=list1.get(i).getIntegral();
        }
        for (int i = 0; i < list2.size(); i++) {
            pingjun2+=list2.get(i).getIntegral();
        }
        if (pingjun1<pingjun && pingjun1<pingjun2){
            ddd="季军";
        }else if(pingjun1>pingjun && pingjun1<pingjun2){
            ddd="亚军";
        }else if(pingjun1>pingjun2 && pingjun1<pingjun){
            ddd="亚军";
        }else if(pingjun1>pingjun2 && pingjun1>pingjun){
            ddd="冠军";
        }
        return ddd;
    }
    public String puanduan2() {
        List<UserEntity> list=applyDao.pingjunfen();
        List<UserEntity> list1=applyDao.pingjunfen1();
        List<UserEntity> list2=applyDao.pingjunfen2();
        Integer pingjun=0;
        Integer pingjun1=0;
        Integer pingjun2=0;
        String  ddd="";
        for (int i = 0; i < list.size(); i++) {
            pingjun+=list.get(i).getIntegral();
        }
        for (int i = 0; i < list1.size(); i++) {
            pingjun1+=list1.get(i).getIntegral();
        }
        for (int i = 0; i < list2.size(); i++) {
            pingjun2+=list2.get(i).getIntegral();
        }
        if (pingjun2<pingjun1 && pingjun2<pingjun){
            ddd="季军";
        }else if(pingjun2>pingjun1 && pingjun2<pingjun){
            ddd="亚军";
        }else if(pingjun2>pingjun && pingjun2<pingjun1){
            ddd="亚军";
        }else if(pingjun2>pingjun && pingjun2>pingjun1){
            ddd="冠军";
        }
        return ddd;
    }
}
