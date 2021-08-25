package com.jk.integral;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

//扩展配置功能
@Configuration
public class MyConfigMvc extends WebMvcConfigurerAdapter {

    //所有的WebMvcConfigurerAdapter组件都会一起起作用
    @Bean //将组件注册在容器
    public WebMvcConfigurerAdapter webMvcConfigurerAdapter() {
        WebMvcConfigurerAdapter adapter = new WebMvcConfigurerAdapter() {
            /*视图映射功能*/
            public void addViewControllers(ViewControllerRegistry registry) {
                //视图映射：浏览器发送"/"请求，会来到index页面（thymeleaf解析的页面），
                registry.addViewController("/index.html").setViewName("/index");
                //工作日志
                registry.addViewController("/workeLog.html").setViewName("/workeLog");
                //写日志
                registry.addViewController("/workbonus.html").setViewName("/workbonus");
                //查看我的日志
                registry.addViewController("/myWorkLog.html").setViewName("/myWorkLog");
                //查看我能看的日志
                registry.addViewController("/workLogForMe.html").setViewName("/workLogForMe");

                registry.addViewController("/Apply_index.html").setViewName("/Apply_index");
                registry.addViewController("/Applyadd.html").setViewName("/Applyadd");
                registry.addViewController("/Applychenggong.html").setViewName("/Applychenggong");
                registry.addViewController("/Apply_nyh.html").setViewName("/Apply_nyh");
                registry.addViewController("/Apply1_nyh.html").setViewName("/Apply1_nyh");
                registry.addViewController("/Apply2_nyh.html").setViewName("/Apply2_nyh");
                registry.addViewController("/Apply3_nyh.html").setViewName("/Apply3_nyh");
                registry.addViewController("/Apply4_nyh.html").setViewName("/Apply4_nyh");
                registry.addViewController("/Apply5_nyh.html").setViewName("/Apply5_nyh");
                registry.addViewController("/Apply6_nyh.html").setViewName("/Apply6_nyh");
                registry.addViewController("/Apply7_nyh.html").setViewName("/Apply7_nyh");
                registry.addViewController("/Apply8_nyh.html").setViewName("/Apply8_nyh");
                registry.addViewController("/Apply9_nyh.html").setViewName("/Apply9zz_nyh");
                registry.addViewController("/ApplyPK.html").setViewName("/ApplyPK");
                registry.addViewController("/login.html").setViewName("/login");


                /**
                 * 牛浩天
                 */
                registry.addViewController("/JiFenPaiMing.html").setViewName("/JiFenPaiMing");
                registry.addViewController("/zong.html").setViewName("/zong");
                registry.addViewController("/zongmo.html").setViewName("/zongmo");
                registry.addViewController("/yue.html").setViewName("/yue");
                registry.addViewController("/yuemo.html").setViewName("/yuemo");
                registry.addViewController("/jin.html").setViewName("/jin");
                registry.addViewController("/jinmo.html").setViewName("/jinmo");

                registry.addViewController("/xuanshangjif.html").setViewName("/xuanshangjif");



                /*胡世坤*/
                /*管理中心*/
                registry.addViewController("/adminIstrationCenter_Hsk.html").setViewName("/adminIstrationCenter_Hsk");
                /*积分制定标准*/
                registry.addViewController("hsk/IntegralSettingStandard_Hsk.html").setViewName("hsk/IntegralSettingStandard_Hsk");
                /*积分审核*/
                registry.addViewController("hsk/PointsAudit_Hsk.html").setViewName("hsk/PointsAudit_Hsk");
            }
        };
        return adapter;
    }
}