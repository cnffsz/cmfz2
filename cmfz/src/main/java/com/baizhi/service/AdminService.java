package com.baizhi.service;

import com.baizhi.entity.Admin;

import java.util.List;

/**
 * Created by 晨妃 on 2018/8/28.
 */
public interface AdminService {
    //  添加管理员
    public void save(Admin admin);

    //  删除
    public void delete(Integer id);

    //  查询
    public List<Admin> queryAll();
}
