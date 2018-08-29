package com.baizhi.service;

import com.baizhi.entity.Banner;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by 晨妃 on 2018/8/29.
 */

public interface BannerService {
    // 添加
    public void save(Banner banner);

    //  删除
    public void delete(Integer id);

    //  修改
    public void update(Banner banner);

    //  查询
    public List<Banner> queryAll();

    // 分页查询
    public List<Banner> queryByPage(int page, int rows);

    //  查询信息条数
    public int count();
}
