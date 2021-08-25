package com.jk.integral.dao;

import com.jk.integral.entity.TreeEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @ClassName TreeDao
 * @Description //TODO $
 * @Date $ $
 * @Author TreeDao
 * @return $
 * @Version 1.0
 **/
@Repository
public interface TreeDao {
    List<TreeEntity> getTree(int pid);
}
