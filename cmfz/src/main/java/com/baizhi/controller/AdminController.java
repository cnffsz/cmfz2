package com.baizhi.controller;

import com.baizhi.entity.Admin;
import com.baizhi.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by 晨妃 on 2018/8/28.
 */
@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private AdminService adminService;

    @RequestMapping("/query")
    public String query(HttpSession session) {
        List<Admin> adminList = adminService.queryAll();
        session.setAttribute("adminList", adminList);
        return "index";
    }

    @RequestMapping("/save")
    public String save(Admin admin) {
        adminService.save(admin);
        return "index";
    }

    @RequestMapping("/delete")
    public String delete(Integer id) {
        adminService.delete(id);
        return "index";
    }
}
