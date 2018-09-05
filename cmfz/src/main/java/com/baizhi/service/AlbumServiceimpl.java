package com.baizhi.service;

import com.baizhi.dao.AlbumDao;
import com.baizhi.entity.Album;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * Created by 晨妃 on 2018/8/30.
 */
@Service
@Transactional
public class AlbumServiceimpl implements AlbumService {
    @Autowired
    private AlbumDao albumDao;

    @Override
    public void save(Album album) {
        album.setCreateDate(new Date());
        albumDao.save(album);
    }

    @Override
    public List<Album> queryAll() {
        List<Album> albumList = albumDao.queryAll();
        return albumList;
    }

    @Override
    public List<Album> queryByPage(int page, int rows) {
        int begin = (page - 1) * rows;// 从下标为多少的信息开始检索
        int end = page * rows;// 到下标为多少的数据结束

        List<Album> albumList = albumDao.queryByPage(begin, end);
        return albumList;
    }

    @Override
    public int count() {
        int count = albumDao.count();
        return count;
    }
}
