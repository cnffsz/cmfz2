package com.baizhi.entity;

import java.io.Serializable;

/**
 * Created by 晨妃 on 2018/8/28.
 */
public class Admin implements Serializable {
    private Integer id;
    private String username;
    private String password;

    @Override
    public String toString() {
        return "Admin{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Admin() {

    }

    public Admin(Integer id, String username, String password) {

        this.id = id;
        this.username = username;
        this.password = password;
    }
}
