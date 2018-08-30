package com.baizhi.controller;

import com.baizhi.entity.Banner;
import com.baizhi.service.BannerService;
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
 * Created by 晨妃 on 2018/8/29.
 */

@Controller
@RequestMapping("/banner")
public class BannerController {
    @Autowired
    private BannerService bannerService;

    @RequestMapping("/save")
    public void save(String title, String description, String status, MultipartFile img, Banner banner, HttpServletRequest request) {
        /*
         *1指定上传文件
         *2防止文件重名
         * 3上传文件夹到指定文件夹
         * 图片存储在webapps 实际项目中 存储到分布式的文件存储系统
        */
        String realpath = request.getServletContext().getRealPath("/");
        String uploadFilePath = realpath + "upload";
        File file = new File(uploadFilePath);
        //如果文件夹不存在 则创建
        if (!file.exists()) {
            file.mkdir();
        }

        String originalFilename = img.getOriginalFilename();

        String uuid = UUID.randomUUID().toString();

        String extension = FilenameUtils.getExtension(originalFilename);

        String newName = uuid + "." + extension;

        try {
            img.transferTo(new File(uploadFilePath, newName));
        } catch (IOException e) {
            e.printStackTrace();
        }
        String imgPath = "/upload/" + newName;
        banner.setImgPath(imgPath);
        banner.setDescription(description);
        banner.setTitle(title);
        banner.setStatus(status);
        bannerService.save(banner);
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
