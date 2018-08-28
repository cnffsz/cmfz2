package com.baizhi.dao;

import com.baizhi.entity.Admin;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by 晨妃 on 2018/8/28.
 */
public interface AdminDao {
    //  添加管理员
    public void save(Admin admin);

    //  删除
    public void delete(Integer id);

    //  查询
    public List<Admin> queryAll();

    // 查一个
    public Admin queryOne(@Param("username") String username, @Param("password") String password);

}
