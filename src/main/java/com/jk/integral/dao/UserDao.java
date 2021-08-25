package com.jk.integral.dao;

import com.jk.integral.entity.Missionhall_fwt;
import com.jk.integral.entity.UserEntity;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao {

    UserEntity getById(Integer id);

    void userEntity(UserEntity userEntity);

    UserEntity UserEntity(UserEntity t);

    Missionhall_fwt select1(Integer id);

    Integer chaxiao1(Integer id);

    void update1(Integer id, Integer xiao);

    void jia(Missionhall_fwt missionhall_fwt);

    void unfinished(Missionhall_fwt missionhall_fwt);

    void wancheng(Missionhall_fwt missionhall_fwt);
}
