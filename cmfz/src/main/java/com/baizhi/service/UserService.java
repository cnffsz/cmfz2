package com.baizhi.service;

import com.baizhi.entity.User;
import com.baizhi.entity.UserDto;

import java.util.List;
import java.util.Map;

/**
 * Created by 晨妃 on 2018/9/4.
 */
public interface UserService {

    // 查询
    public Map<String, Object> query();

    // 查询用户地区分布
    public Map<String, Object> queryByProvince();

}
