package com.baizhi.controller;

import com.baizhi.entity.Chapter;
import com.baizhi.service.ChapterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by 晨妃 on 2018/8/30.
 */
@Controller
@RequestMapping("/chapter")
public class ChapterController {
    @Autowired
    private ChapterService chapterService;

    @RequestMapping("/save")
    public void save(Chapter chapter) {
        chapterService.save(chapter);
    }

    @RequestMapping("/queryAll")
    @ResponseBody
    public List<Chapter> queryAll() {
        List<Chapter> chapterList = chapterService.queryAll();
        return chapterList;
    }

    @RequestMapping("/queryByPage")
    @ResponseBody
    public Map<String, Object> queryByPage(Integer page, Integer rows) {
        Map<String, Object> map = new HashMap<>();

        Integer count = chapterService.count();
        List<Chapter> chapterList = chapterService.queryByPage(page, rows);
        map.put("total", count);
        map.put("rows", chapterList);
        return map;
    }


}
