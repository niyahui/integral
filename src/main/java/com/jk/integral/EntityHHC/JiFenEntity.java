package com.jk.integral.EntityHHC;

import lombok.Data;

@Data
public class JiFenEntity {

//表名 scorecard_jif_hhc    积分悬赏

    private Integer linqu_id;//编号
    private Integer jifen;//积分
    private Integer state; //状态  1待完成  2已完成
    private String shengher_name;//操作人员
    private String headline;////标题
    private String mioashu; //描述
    private Integer use_id;//关联个人id



   /* //表名  jinrijifenhhc 今日积分 总表
    id	        int				        编号
    danhao	    varchar					单号
    jifBiaot	varchar					积分标题
    jiangkoUser	varchar					奖金扣分对象
    bumeng	    int				        部门，
                1红岭店，2西乡店，3财务部，4东区生保组，5东菀店，6人事部，7文峰店，8深大店，9盐田店					0	0	0	0	0	0	0

    jifenNumber	int			            积分数
    shengqName	varchar					申请人
    shengheName	varchar					审核人
    shenghDate	date					审核时间
    xiangq	    varchar
*/
    private Integer id;
    private String danhao;
    private String jifBiaot;
    private String jiangkoUser;
    private Integer bumeng;
    private Integer jifenNumber;
    private String shengqName;
    private String shengheName;
    private String shenghDate;
    private String xiangq;

    //业务字段
    private Integer number;//人数  总加分
    private Integer zonjifenNumae;//总加分
    private Integer pjjif;//平均分  总加分
    private Integer bm;//部门  总加发


    private Integer number2;//人数  总减分
    private Integer zonjifenNumae2;//总减分
    private Integer pjjif2;//平均分  总减分
    private Integer bm2;//部门  总减发


}