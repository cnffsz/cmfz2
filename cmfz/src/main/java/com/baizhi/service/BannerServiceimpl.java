package com.baizhi.service;

import com.baizhi.dao.BannerDao;
import com.baizhi.entity.Banner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by 晨妃 on 2018/8/29.
 */
@Service
@Transactional
public class BannerServiceimpl implements BannerService {
    @Autowired
    private BannerDao bannerDao;

    @Override
    public void save(Banner banner) {

        bannerDao.save(banner);
    }

    @Override
    public void delete(Integer id) {
        bannerDao.delete(id);
    }

    @Override
    public void update(Banner banner) {

        bannerDao.update(banner);
    }

    @Override
    public List<Banner> queryAll() {
        List<Banner> bannerList = bannerDao.queryAll();
        return bannerList;
    }

    @Override
    public List<Banner> queryByPage(int page, int rows) {

        int begin = (page - 1) * rows;// 从下标为多少的信息开始检索
        int end = page * rows;// 到下标为多少的数据结束
        System.out.println(begin);
        System.out.println(end);
        List<Banner> bannerList = bannerDao.queryByPage(begin, end);
        return bannerList;
    }

    @Override
    public int count() {
        int count = bannerDao.count();
        return count;
    }

}
