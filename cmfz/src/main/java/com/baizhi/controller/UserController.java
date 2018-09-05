
package com.baizhi.controller;

import com.baizhi.entity.UserDto;
import com.baizhi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * Created by 晨妃 on 2018/9/4.
 */


@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @ResponseBody
    @RequestMapping("/query")
    public Map<String, Object> query() {
        Map<String, Object> map = userService.query();
        return map;
    }


    @ResponseBody
    @RequestMapping("/china")
    public Map<String, Object> queryByProvince() {
        Map<String, Object> map = userService.queryByProvince();
        return map;
    }
}

