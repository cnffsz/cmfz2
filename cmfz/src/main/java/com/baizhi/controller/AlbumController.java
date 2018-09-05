package com.baizhi.controller;

import com.baizhi.entity.Album;
import com.baizhi.service.AlbumService;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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

@RestController
@RequestMapping("/album")
public class AlbumController {
    @Autowired
    private AlbumService albumService;

    @RequestMapping("/save")
    //String title,Integer count,String brief,String status
    public void save(String title, Integer count, String brief, String status, MultipartFile corverimg, HttpServletRequest request) {
        //System.out.println(title+"."+count+"."+brief+"."+status);
        System.out.println("--------------");
        //System.out.println(album.getTitle());
        Album album = new Album();
        /*
         *1指定上传文件
         *2防止文件重名
         *3上传文件夹到指定文件夹
         *图片存储在webapps 实际项目中 存储到分布式的文件存储系统
        */
        String realpath = request.getServletContext().getRealPath("/");
        String uploadFilePath = realpath + "upload";
        File file = new File(uploadFilePath);
        //如果文件夹不存在 则创建
        if (!file.exists()) {
            file.mkdir();
        }

        String originalFilename = corverimg.getOriginalFilename();

        String uuid = UUID.randomUUID().toString();

        String extension = FilenameUtils.getExtension(originalFilename);

        String newName = uuid + "." + extension;

        try {
            corverimg.transferTo(new File(uploadFilePath, newName));
        } catch (IOException e) {
            e.printStackTrace();
        }
        String imgPath = "/upload/" + newName;
        album.setCorverimg(imgPath);
        album.setId(uuid);

        album.setBrief(brief);
        album.setCount(count);
        album.setStatus(status);
        album.setTitle(title);
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
