package com.baizhi.service;

import com.baizhi.dao.AdminDao;
import com.baizhi.entity.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by 晨妃 on 2018/8/28.
 */
@Service
@Transactional
public class AdminServiceimpl implements AdminService {
    @Autowired
    private AdminDao adminDao;

    @Override
    public void save(Admin admin) {
        adminDao.save(admin);
    }

    @Override
    public void delete(Integer id) {
        adminDao.delete(id);
    }

    @Override
    public List<Admin> queryAll() {
        List<Admin> adminList = adminDao.queryAll();
        return adminList;
    }

    @Override
    public Admin queryOne(String username, String password) {
        Admin admin = adminDao.queryOne(username, password);
        return admin;
    }
}
