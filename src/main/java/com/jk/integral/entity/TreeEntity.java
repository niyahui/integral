package com.jk.integral.entity;

import lombok.Data;

import java.util.List;

/**
 * @ClassName TreeEntity
 * @Description //TODO $
 * @Date $ $
 * @Author TreeEntity
 * @return $
 * @Version 1.0
 **/
@Data
public class TreeEntity {
    private Integer id;
    private String text;
    private Integer pid;
    private String url;
    private List<TreeEntity> nodes;
    private Boolean selectable;
}
