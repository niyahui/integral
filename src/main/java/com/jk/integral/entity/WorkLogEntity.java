package com.jk.integral.entity;

import lombok.Data;

/**
 * @ClassName WorkLogEntity
 * @Description //TODO $
 * @Date $ $
 * @Author WorkLogEntity
 * @return $
 * @Version 1.0
 * 表名: worklog_yz
 **/
@Data
public class WorkLogEntity {
    /**
     * 主键ID
     */
    private Integer log_id;
    /**
     *编号
     */
    private String number;
    /**
     *人员ID
     */
    private Integer user_id;
    /**
     *总结内容
     */
    private String summary;
    /**
     *计划内容
     */
    private String plan;
    /**
     *总结时间
     */
    private String sumdate;
    /**
     *谁能看见
     */
    private Integer visible;

    /**
     * 最小时间
     */
    private String mindate;
    /**
     * 最大时间
     */
    private String maxdate;
}
