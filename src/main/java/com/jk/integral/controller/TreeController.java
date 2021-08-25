package com.jk.integral.controller;

import com.jk.integral.entity.TreeEntity;
import com.jk.integral.service.TreeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @ClassName TreeController
 * @Description //TODO $
 * @Date $ $
 * @Author TreeController
 * @return $
 * @Version 1.0
 **/
@Controller
public class TreeController {
    @Autowired
    private TreeService treeService;



    @RequestMapping("getTree")
    @ResponseBody
    public List<TreeEntity> getTree(){
        int pid=0;
        return treeService.getTree(pid);
    }


}
