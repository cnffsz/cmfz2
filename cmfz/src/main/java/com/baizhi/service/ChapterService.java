package com.baizhi.service;

import com.baizhi.entity.Chapter;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by 晨妃 on 2018/8/30.
 */
public interface ChapterService {
    // 添加
    public void save(Chapter chapter);

    // 删除
    //public void delete(Integer id);
    // 修改
    //public void update(Chapter chapter);
    // 查询
    public List<Chapter> queryAll();

    // 分页查询
    public List<Chapter> queryByPage(int page, int rows);

    //  总信息数量
    public Integer count();
}
