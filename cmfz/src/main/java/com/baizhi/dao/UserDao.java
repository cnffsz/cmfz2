package com.baizhi.dao;

import com.baizhi.entity.User;
import com.baizhi.entity.UserDto;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by 晨妃 on 2018/9/4.
 */
public interface UserDao {
    //查询男/女
    public Integer query(@Param("sex") String sex, @Param("i") Integer i);

    //查询各个省份男女用户的数量
    public List<UserDto> queryByprovince(String sex);


}
