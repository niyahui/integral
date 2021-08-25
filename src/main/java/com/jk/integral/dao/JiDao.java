package com.jk.integral.dao;

import com.jk.integral.entity.IntegralEntityNht;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface JiDao {
    List<IntegralEntityNht> zong();

    List<IntegralEntityNht> zongmo();

    List<IntegralEntityNht> yue();

    List<IntegralEntityNht> yuemo();

    List<IntegralEntityNht> jin();

    List<IntegralEntityNht> jinmo();

    IntegralEntityNht zongname();

    IntegralEntityNht yuename();

    IntegralEntityNht jinname();

    List<IntegralEntityNht> zongxiang();

    List<IntegralEntityNht> zongmoxiang();

    List<IntegralEntityNht> yuexiang();

    List<IntegralEntityNht> yuemoxiang();

    List<IntegralEntityNht> jinxiang();

    List<IntegralEntityNht> jinmoxiang();

    List<IntegralEntityNht> yonghuzong(Integer id);
}
