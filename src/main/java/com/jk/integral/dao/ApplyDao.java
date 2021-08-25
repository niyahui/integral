package com.jk.integral.dao;

import com.jk.integral.entity.ApplyEntity_nyh;
import com.jk.integral.entity.IntegralStandardHskEntity;
import com.jk.integral.entity.UserEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ApplyDao {

    List<ApplyEntity_nyh> apply1(Integer id);
    List<ApplyEntity_nyh> apply();

    List<ApplyEntity_nyh> leibie(Integer pid);

    void applyadd(ApplyEntity_nyh applyEntity_nyh);

    void chexiao(Integer id);

    ApplyEntity_nyh gethui(Integer id);

    List<ApplyEntity_nyh> applycha();

    List<ApplyEntity_nyh> applyup(Integer id);

    List<UserEntity> jifenpk();

    List<UserEntity> pingjunfen();

    List<UserEntity> jifenpk2();
    List<UserEntity> jifenpk3();

    List<UserEntity> pingjunfen1();
    List<UserEntity> pingjunfen2();
}
