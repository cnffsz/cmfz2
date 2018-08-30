package com.baizhi.dao;

import com.baizhi.entity.Album;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by 晨妃 on 2018/8/30.
 */
public interface AlbumDao {
    // 添加
    public void save(Album album);

    //  删除
    //public void delete(Integer id);
    //  修改
    //public void update(Album album);
    //  查询
    public List<Album> queryAll();

    // 分页查询
    public List<Album> queryByPage(@Param("begin") int begin, @Param("end") int end);

    //  查询信息条数
    public int count();
}
