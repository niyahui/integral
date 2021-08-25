package com.jk.integral.controller;

import com.jk.integral.entity.ApplyEntity_nyh;
import com.jk.integral.entity.IntegralStandardHskEntity;
import com.jk.integral.entity.UserEntity;
import com.jk.integral.service.ApplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
public class ApplyController {
    @Autowired
    private ApplyService applyService;
//123213
    /**
     * 选择标准查询列表
     * @return
     */
    @RequestMapping("apply1")
    public List<ApplyEntity_nyh> apply1(){
        return applyService.apply1();
    }

    @RequestMapping("apply2")
    public List<ApplyEntity_nyh> apply2(){
        Integer id=2;
        return applyService.apply(id);
    }
    @RequestMapping("apply3")
    public List<ApplyEntity_nyh> apply3(){
        Integer id=3;
        return applyService.apply(id);
    }
    @RequestMapping("apply4")
    public List<ApplyEntity_nyh> apply4(){
        Integer id=4;
        return applyService.apply(id);
    }
    @RequestMapping("apply5")
    public List<ApplyEntity_nyh> apply5(){
        Integer id=5;
        return applyService.apply(id);
    }
    @RequestMapping("apply6")
    public List<ApplyEntity_nyh> apply6(){
        Integer id=6;
        return applyService.apply(id);
    }
    @RequestMapping("apply7")
    public List<ApplyEntity_nyh> apply7(){
        Integer id=7;
        return applyService.apply(id);
    }
    @RequestMapping("apply8")
    public List<ApplyEntity_nyh> apply8(){
        Integer id=8;
        return applyService.apply(id);
    }
    @RequestMapping("apply9")
    public List<ApplyEntity_nyh> apply9(){
        Integer id=9;
        return applyService.apply(id);
    }
    @RequestMapping("apply10")
    public List<ApplyEntity_nyh> apply10(){
        Integer id=10;
        return applyService.apply(id);
    }
    @RequestMapping("apply11")
    public List<ApplyEntity_nyh> apply11(){
        Integer id=11;
        return applyService.apply(id);
    }

    /**
     * 填写申请回显
     * @return
     */
    @RequestMapping("leibie")
    public List<ApplyEntity_nyh> leibie(){
        Integer pid=0;
        return applyService.leibie(pid);
    }

    /**
     * 申请成功查询
     * @return
     */
    @RequestMapping("applycha")
    public List<ApplyEntity_nyh> applycha(){
        return applyService.applycha();
    }

    /**
     *填写申请
     */
    @RequestMapping("applyadd")
    public void applyadd(ApplyEntity_nyh applyEntity_nyh,HttpServletRequest request){
         applyService.applyadd(applyEntity_nyh,request);
    }


    /**
     * 撤销
     * @param id
     */
    @RequestMapping("chexiao")
    public void chexiao(Integer id){
        applyService.chexiao(id);
    }

    /**
     * 回显
     * @return
     */
    @RequestMapping("gethui")
    public ApplyEntity_nyh gethui(HttpServletRequest request){

        return applyService.gethui(request);
    }

    /**
     *
     * @return
     */
    @RequestMapping("applyup")
    public List<ApplyEntity_nyh> applyup(Integer id, HttpServletRequest request){
        return applyService.applyup(id,request);
    }

    /**
     * 积分PK
     * @return
     */
    @RequestMapping("jifenpk")
    public List<UserEntity> jifenpk(){
        return applyService.jifenpk();
    }
    @RequestMapping("jifenpk2")
    public List<UserEntity> jifenpk2(){
        return applyService.jifenpk2();
    }
    @RequestMapping("jifenpk3")
    public List<UserEntity> jifenpk3(){
        return applyService.jifenpk3();
    }

    /**
     * 积分PK 平均分查询
     * @return
     */
    @RequestMapping("pingjunfen")
    public Integer  pingjunfen(){
        return applyService.pingjunfen();
    }
    @RequestMapping("pingjunfen1")
    public Integer  pingjunfen1(){
        return applyService.pingjunfen1();
    }
    @RequestMapping("pingjunfen2")
    public Integer  pingjunfen2(){
        return applyService.pingjunfen2();
    }

    /**
     * 排名
     * @return
     */
    @RequestMapping("puanduan")
    public String puanduan(){
        return applyService.puanduan();
    }
    @RequestMapping("puanduan1")
    public String puanduan1(){
        return applyService.puanduan1();
    }
    @RequestMapping("puanduan2")
    public String puanduan2(){
        return applyService.puanduan2();
    }
}
