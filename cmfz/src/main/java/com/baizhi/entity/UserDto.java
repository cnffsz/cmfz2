package com.baizhi.entity;

import java.io.Serializable;

/**
 * Created by 晨妃 on 2018/9/4.
 */
public class UserDto implements Serializable {
    /*
    *在用户的地图分布的时候，查询的是数量和省份，
    * 其返回值是2个不同的类型，所以使用UserDto这个中间量
    */
    private Integer value;
    private String name;

    @Override
    public String toString() {
        return "UserDto{" +
                "value=" + value +
                ", name='" + name + '\'' +
                '}';
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UserDto() {

    }

    public UserDto(Integer value, String name) {

        this.value = value;
        this.name = name;
    }
}
