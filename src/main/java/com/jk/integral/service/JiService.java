package com.jk.integral.service;

import com.jk.integral.dao.JiDao;
import com.jk.integral.entity.IntegralEntityNht;
import com.jk.integral.entity.TreeEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JiService {

    @Autowired
    private JiDao jiDao;


    public List<IntegralEntityNht> zong() {
        List<IntegralEntityNht> list =jiDao.zong();
        Integer  a=1;
        for (IntegralEntityNht tree : list) {
            tree.setPaiming(a);
            a++;
        }
     return  list;
    }

    public List<IntegralEntityNht> zongmo() {
        List<IntegralEntityNht> list =jiDao.zongmo();
        Integer  a=1;
        for (IntegralEntityNht tree : list) {
            tree.setPaiming(a);
            a++;
        }
        return  list;
    }

    public List<IntegralEntityNht> yue() {
        List<IntegralEntityNht> list =jiDao.yue();
        Integer  a=1;
        for (IntegralEntityNht tree : list) {
            tree.setPaiming(a);
            a++;
        }
        return  list;
    }

    public List<IntegralEntityNht> yuemo() {
        List<IntegralEntityNht> list =jiDao.yuemo();
        Integer  a=1;
        for (IntegralEntityNht tree : list) {
            tree.setPaiming(a);
            a++;
        }
        return  list;
    }

    public List<IntegralEntityNht> jin() {
        List<IntegralEntityNht> list =jiDao.jin();
        Integer  a=1;
        for (IntegralEntityNht tree : list) {
            tree.setPaiming(a);
            a++;
        }
        return  list;
    }

    public List<IntegralEntityNht> jinmo() {
        List<IntegralEntityNht> list =jiDao.jinmo();
        Integer  a=1;
        for (IntegralEntityNht tree : list) {
            tree.setPaiming(a);
            a++;
        }
        return  list;
    }

    public IntegralEntityNht zongname() {
        return jiDao.zongname();
    }

    public IntegralEntityNht yuename() {
        return jiDao.yuename();
    }

    public IntegralEntityNht jinname() {
        return jiDao.jinname();
    }

    public List<IntegralEntityNht> zongxiang() {
        List<IntegralEntityNht> list =jiDao.zongxiang();
        Integer  a=1;
        Integer  b=1;
        for (int i = 0; i < list.size(); i++) {
            if (b!=list.size()){
          if (list.get(i).getZongjifen()!=list.get(b).getZongjifen()){
              list.get(i).setPaiming(a);
              a++;
          }else {
              list.get(i).setPaiming(a);
          }
                b++;
            }else {
                list.get(i).setPaiming(a);
                a++;
            }
        }
        return  list;
    }

    public List<IntegralEntityNht> zongmoxiang() {
        List<IntegralEntityNht> list =jiDao.zongmoxiang();
        Integer  a=1;
        Integer  b=1;
        for (int i = 0; i < list.size(); i++) {
            if (b!=list.size()){
                if (list.get(i).getZongjifen()!=list.get(b).getZongjifen()){
                    list.get(i).setPaiming(a);
                    a++;
                }else {
                    list.get(i).setPaiming(a);
                }
                b++;
            }else {
                list.get(i).setPaiming(a);
                a++;
            }
        }
        return  list;
    }

    public List<IntegralEntityNht> yuexiang() {
        List<IntegralEntityNht> list =jiDao.yuexiang();
        Integer  a=1;
        Integer  b=1;
        for (int i = 0; i < list.size(); i++) {
            if (b!=list.size()){
                if (list.get(i).getZongjifen()!=list.get(b).getZongjifen()){
                    list.get(i).setPaiming(a);
                    a++;
                }else {
                    list.get(i).setPaiming(a);
                }
                b++;
            }else {
                list.get(i).setPaiming(a);
                a++;
            }
        }
        return  list;
    }

    public List<IntegralEntityNht> yuemoxiang() {
        List<IntegralEntityNht> list =jiDao.yuemoxiang();
        Integer  a=1;
        Integer  b=1;
        for (int i = 0; i < list.size(); i++) {
            if (b!=list.size()){
                if (list.get(i).getZongjifen()!=list.get(b).getZongjifen()){
                    list.get(i).setPaiming(a);
                    a++;
                }else {
                    list.get(i).setPaiming(a);
                }
                b++;
            }else {
                list.get(i).setPaiming(a);
                a++;
            }
        }
        return  list;
    }

    public List<IntegralEntityNht> jinxiang() {
        List<IntegralEntityNht> list =jiDao.jinxiang();
        Integer  a=1;
        Integer  b=1;
        for (int i = 0; i < list.size(); i++) {
            if (b!=list.size()){
                if (list.get(i).getZongjifen()!=list.get(b).getZongjifen()){
                    list.get(i).setPaiming(a);
                    a++;
                }else {
                    list.get(i).setPaiming(a);
                }
                b++;
            }else {
                list.get(i).setPaiming(a);
                a++;
            }
        }
        return  list;
    }

    public List<IntegralEntityNht> jinmoxiang() {
        List<IntegralEntityNht> list =jiDao.jinmoxiang();
        Integer  a=1;
        Integer  b=1;
        for (int i = 0; i < list.size(); i++) {
            if (b!=list.size()){
                if (list.get(i).getZongjifen()!=list.get(b).getZongjifen()){
                    list.get(i).setPaiming(a);
                    a++;
                }else {
                    list.get(i).setPaiming(a);
                }
                b++;
            }else {
                list.get(i).setPaiming(a);
                a++;
            }
        }
        return  list;
    }

    public List<IntegralEntityNht> yonghuzong(Integer id) {
      return   jiDao.yonghuzong(id);
    }
}
