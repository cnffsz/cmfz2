package com.baizhi.service;

import com.baizhi.dao.MenuDao;
import com.baizhi.entity.Menu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by 晨妃 on 2018/8/29.
 */
@Service
@Transactional
public class MenuServiceimpl implements MenuService {
    @Autowired
    private MenuDao menuDao;

    @Override
    public List<Menu> queryAll() {
        List<Menu> menus = menuDao.queryAll();
        return menus;
    }
}
