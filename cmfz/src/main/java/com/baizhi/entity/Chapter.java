package com.baizhi.entity;

import java.io.Serializable;

/**
 * Created by 晨妃 on 2018/8/30.
 */
public class Chapter implements Serializable {
    private String id;
    private String title;
    private String duration;
    private String size;
    private String audioPath;

    private Album children;


    @Override
    public String toString() {
        return "Chapter{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", duration='" + duration + '\'' +
                ", size='" + size + '\'' +
                ", audioPath='" + audioPath + '\'' +
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

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getAudioPath() {
        return audioPath;
    }

    public void setAudioPath(String audioPath) {
        this.audioPath = audioPath;
    }

    public Album getChildren() {
        return children;
    }

    public void setChildren(Album children) {
        this.children = children;
    }

    public Chapter() {

    }

    public Chapter(String id, String title, String duration, String size, String audioPath, Album children) {

        this.id = id;
        this.title = title;
        this.duration = duration;
        this.size = size;
        this.audioPath = audioPath;
        this.children = children;
    }
}
