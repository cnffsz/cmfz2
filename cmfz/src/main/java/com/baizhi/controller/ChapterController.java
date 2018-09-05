package com.baizhi.controller;

import com.baizhi.entity.Chapter;
import com.baizhi.service.ChapterService;
import com.baizhi.util.Mp3Util;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * Created by 晨妃 on 2018/8/30.
 */
@Controller
@RequestMapping("/chapter")
public class ChapterController {
    @Autowired
    private ChapterService chapterService;

    @RequestMapping("/save")
    public void save(String chaptertitle, HttpServletRequest request, MultipartFile music, String id) {
        System.out.println(id);
        System.out.println(chaptertitle);
        Chapter chapter = new Chapter();
        /*
         *1指定上传文件
         *2防止文件重名
         * 3上传文件夹到指定文件夹
         * 图片存储在webapps 实际项目中 存储到分布式的文件存储系统
        */
        String realpath = request.getServletContext().getRealPath("/");
        String uploadFilePath = realpath + "musicfile";
        File file = new File(uploadFilePath);
        //如果文件夹不存在 则创建
        if (!file.exists()) {
            file.mkdir();
        }

        String originalFilename = music.getOriginalFilename();
        String uuid = UUID.randomUUID().toString();
        String extension = FilenameUtils.getExtension(originalFilename);
        String newName = uuid + "." + extension;

        try {
            //将文件进行上传到指定目录
            music.transferTo(new File(uploadFilePath, newName));
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 获得音频文件的时长
        File file1 = new File(uploadFilePath + "/" + newName);
        String duration = Mp3Util.getDuration(file1);
        // 获得音频文件的大小
        long length = music.getSize();
        long fsize = length / 1048576;
        String fielsize = fsize + "" + "MB";//转为String类型

        String musicPath = "/musicfile/" + newName;
        //为chapter属性赋值
        chapter.setAudioPath(musicPath);
        chapter.setTitle(chaptertitle);
        chapter.setSize(fielsize);
        chapter.setDuration(duration);
        chapter.setAlbumId(id);
        //提交到后台
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
