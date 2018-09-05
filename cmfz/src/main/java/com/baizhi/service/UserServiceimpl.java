package com.baizhi.service;

import com.baizhi.dao.UserDao;
import com.baizhi.entity.User;
import com.baizhi.entity.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by 晨妃 on 2018/9/4.
 */
@Service
@Transactional
public class UserServiceimpl implements UserService {
    @Autowired
    private UserDao userDao;


    @Override
    public Map<String, Object> query() {
            /*
            * 循环一次就加进去一次的数据 例如第一周的数据x轴为近1周 数据分别查询男和女
            * 创建2哥list集合 mans womens 然后把查询的数据分别加到各自的list集合里面
            * 在传参的时候根据Mapper里面的sql 传进去sex为M则查询的为男的数量
            * 传进去的参数sex为W 则查询的数据为女的数量
            */
        List<String> strs = new ArrayList<String>();
        List<Integer> mans = new ArrayList<Integer>();
        List<Integer> womens = new ArrayList<Integer>();
        Map<String, Object> map = new HashMap<String, Object>();

        for (int j = 1; j < 5; j++) {

            String s = "第" + j + "周";
            strs.add(s);
            //查询男 加进去
            Integer m = userDao.query("M", j);
            mans.add(m);
            //查询女 加进去
            Integer w = userDao.query("W", j);
            womens.add(w);
            //将以上加进map集合
            map.put("xAxis", strs);
            map.put("mans", mans);
            map.put("womens", womens);
        }
        return map;
    }

    @Override
    public Map<String, Object> queryByProvince() {
        Map<String, Object> map = new HashMap<String, Object>();
        List<UserDto> m = userDao.queryByprovince("M");
        List<UserDto> w = userDao.queryByprovince("W");

        map.put("mans", m);
        map.put("womens", w);
        return map;
    }
}
