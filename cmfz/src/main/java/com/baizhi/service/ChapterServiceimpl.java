package com.baizhi.service;

import com.baizhi.dao.ChapterDao;
import com.baizhi.entity.Chapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by 晨妃 on 2018/8/30.
 */
@Service
@Transactional
public class ChapterServiceimpl implements ChapterService {
    @Autowired
    private ChapterDao chapterDao;

    @Override
    public void save(Chapter chapter) {
        chapterDao.save(chapter);
    }

    @Override
    public List<Chapter> queryAll() {
        List<Chapter> chapterList = chapterDao.queryAll();
        return chapterList;
    }

    @Override
    public List<Chapter> queryByPage(int page, int rows) {
        int begin = (page - 1) * rows;// 从下标为多少的信息开始检索
        int end = page * rows;// 到下标为多少的数据结束
        List<Chapter> chapterList = chapterDao.queryByPage(begin, end);
        return chapterList;
    }

    @Override
    public Integer count() {
        Integer count = chapterDao.count();
        return count;
    }
}
