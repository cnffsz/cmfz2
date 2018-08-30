package com.baizhi.controller;

import com.baizhi.entity.Album;
import com.baizhi.service.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by 晨妃 on 2018/8/30.
 */

@RestController
@RequestMapping("/album")
public class AlbumController {
    @Autowired
    private AlbumService albumService;

    @RequestMapping("/save")
    public void save(Album album) {
        albumService.save(album);
    }

    @RequestMapping("/queryAll")
    public List<Album> queryAll() {
        List<Album> albumList = albumService.queryAll();
        return albumList;
    }

    @RequestMapping("/queryByPage")
    public Map<String, Object> queryByPage(Integer page, Integer rows) {
        Map<String, Object> map = new HashMap<String, Object>();
        List<Album> albumList = albumService.queryByPage(page, rows);
        int count = albumService.count();

        map.put("total", count);
        map.put("rows", albumList);
        return map;
    }

}
