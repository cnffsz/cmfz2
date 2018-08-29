package com.baizhi.controller;

import com.baizhi.entity.Banner;
import com.baizhi.service.BannerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by 晨妃 on 2018/8/29.
 */

@Controller
@RequestMapping("/banner")
public class BannerController {
    @Autowired
    private BannerService bannerService;

    @RequestMapping("/save")
    public String save(Banner banner) {
        bannerService.save(banner);
        return "index";
    }

    @RequestMapping("/delete")
    public String delete(Integer id) {
        bannerService.delete(id);
        return "index";
    }

    @RequestMapping("/update")
    public String update(Banner banner) {
        bannerService.update(banner);
        return "index";
    }

    @ResponseBody
    @RequestMapping("/queryAll")
    public List<Banner> queryAll() {
        List<Banner> bannerList = bannerService.queryAll();
        return bannerList;
    }

    @ResponseBody
    @RequestMapping("/queryByPage")
    public Map<String, Object> queryByPage(Integer page, Integer rows) {
        Map<String, Object> map = new HashMap<String, Object>();
        //  easyui要求传入一个map集合 第一个传入总的信息数，第二个传入分页传入的数据集合
        List<Banner> bannerList = bannerService.queryByPage(page, rows);
        int count = bannerService.count();
        map.put("total", count);
        map.put("rows", bannerList);
        return map;
    }

}
