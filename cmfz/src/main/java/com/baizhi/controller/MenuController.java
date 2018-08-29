package com.baizhi.controller;

import com.baizhi.entity.Menu;
import com.baizhi.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by 晨妃 on 2018/8/29.
 */
@Controller
@RequestMapping("/menu")
public class MenuController {
    @Autowired
    private MenuService menuService;

    @ResponseBody
    @RequestMapping("/queryAll")
    public List<Menu> queryAll(HttpSession session) {
        List<Menu> menus = menuService.queryAll();
        session.setAttribute("menus", menus);
        return menus;
    }
}
