package com.baizhi.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Created by 晨妃 on 2018/8/30.
 */
public class Album implements Serializable {
    private String id;
    private String title;
    private Integer count;
    private String corverimg;
    private Double score;
    private String author;
    private String broaderCast;
    private String brief;
    private Date publicDate;
    private Date createDate;
    private String status;

    private List<Chapter> children;


    @Override
    public String toString() {
        return "Album{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", count=" + count +
                ", corverimg='" + corverimg + '\'' +
                ", score=" + score +
                ", author='" + author + '\'' +
                ", broaderCast='" + broaderCast + '\'' +
                ", brief='" + brief + '\'' +
                ", publicDate=" + publicDate +
                ", createDate=" + createDate +
                ", status='" + status + '\'' +
                ", children=" + children +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public String getCorverimg() {
        return corverimg;
    }

    public void setCorverimg(String corverimg) {
        this.corverimg = corverimg;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getBroaderCast() {
        return broaderCast;
    }

    public void setBroaderCast(String broaderCast) {
        this.broaderCast = broaderCast;
    }

    public String getBrief() {
        return brief;
    }

    public void setBrief(String brief) {
        this.brief = brief;
    }

    public Date getPublicDate() {
        return publicDate;
    }

    public void setPublicDate(Date publicDate) {
        this.publicDate = publicDate;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<Chapter> getChildren() {
        return children;
    }

    public void setChildren(List<Chapter> children) {
        this.children = children;
    }

    public Album() {

    }

    public Album(String id, String title, Integer count, String corverimg, Double score, String author, String broaderCast, String brief, Date publicDate, Date createDate, String status, List<Chapter> children) {

        this.id = id;
        this.title = title;
        this.count = count;
        this.corverimg = corverimg;
        this.score = score;
        this.author = author;
        this.broaderCast = broaderCast;
        this.brief = brief;
        this.publicDate = publicDate;
        this.createDate = createDate;
        this.status = status;
        this.children = children;
    }
}
