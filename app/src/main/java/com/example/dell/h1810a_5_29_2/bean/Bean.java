package com.example.dell.h1810a_5_29_2.bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;
@Entity
public class Bean {

    @Id
    private Long longid;

    private String title;
    private int url;
    @Generated(hash = 159686802)
    public Bean(Long longid, String title, int url) {
        this.longid = longid;
        this.title = title;
        this.url = url;
    }
    @Generated(hash = 80546095)
    public Bean() {
    }
    public Long getLongid() {
        return this.longid;
    }
    public void setLongid(Long longid) {
        this.longid = longid;
    }
    public String getTitle() {
        return this.title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public int getUrl() {
        return this.url;
    }
    public void setUrl(int url) {
        this.url = url;
    }


}
