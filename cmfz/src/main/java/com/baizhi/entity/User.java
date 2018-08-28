package com.baizhi.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by 晨妃 on 2018/8/28.
 */
public class User implements Serializable {
    private Integer id;
    private Integer guru_id;
    private String photoImg;
    private String name;
    private String dharmaName;
    private String sex;
    private String province;
    private String city;
    private String sign;
    private Integer phoneNum;
    private String password;
    private String salt;
    private String status;
    private Date registDate;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", guru_id=" + guru_id +
                ", photoImg='" + photoImg + '\'' +
                ", name='" + name + '\'' +
                ", dharmaName='" + dharmaName + '\'' +
                ", sex='" + sex + '\'' +
                ", province='" + province + '\'' +
                ", city='" + city + '\'' +
                ", sign='" + sign + '\'' +
                ", phoneNum=" + phoneNum +
                ", password='" + password + '\'' +
                ", salt='" + salt + '\'' +
                ", status='" + status + '\'' +
                ", registDate=" + registDate +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getGuru_id() {
        return guru_id;
    }

    public void setGuru_id(Integer guru_id) {
        this.guru_id = guru_id;
    }

    public String getPhotoImg() {
        return photoImg;
    }

    public void setPhotoImg(String photoImg) {
        this.photoImg = photoImg;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDharmaName() {
        return dharmaName;
    }

    public void setDharmaName(String dharmaName) {
        this.dharmaName = dharmaName;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public Integer getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(Integer phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getRegistDate() {
        return registDate;
    }

    public void setRegistDate(Date registDate) {
        this.registDate = registDate;
    }

    public User(Integer id, Integer guru_id, String photoImg, String name, String dharmaName, String sex, String province, String city, String sign, Integer phoneNum, String password, String salt, String status, Date registDate) {

        this.id = id;
        this.guru_id = guru_id;
        this.photoImg = photoImg;
        this.name = name;
        this.dharmaName = dharmaName;
        this.sex = sex;
        this.province = province;
        this.city = city;
        this.sign = sign;
        this.phoneNum = phoneNum;
        this.password = password;
        this.salt = salt;
        this.status = status;
        this.registDate = registDate;
    }

    public User() {

    }
}
