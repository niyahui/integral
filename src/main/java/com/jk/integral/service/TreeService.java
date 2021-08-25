package com.jk.integral.service;

import com.jk.integral.dao.TreeDao;
import com.jk.integral.entity.TreeEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName TreeService
 * @Description //TODO $
 * @Date $ $
 * @Author TreeService
 * @return $
 * @Version 1.0
 **/
@Service
public class TreeService {
    @Autowired
    private TreeDao treeDao;

    public List<TreeEntity> getTree(int pid) {
        List<TreeEntity> list=treeDao.getTree(pid);
        for (TreeEntity tree : list) {
            List<TreeEntity> list2=getTree(tree.getId());
            if (list2!=null&&list2.size()>0) {
                tree.setSelectable(false);
                tree.setNodes(list2);
            }else{
                tree.setSelectable(true);
            }
        }
        return list;
    }
}
