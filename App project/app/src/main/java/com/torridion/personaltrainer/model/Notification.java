package com.torridion.personaltrainer.model;


import java.util.Date;

import io.realm.RealmObject;

public class Notification extends RealmObject{

    private Date creationDate;
    private Date notificationDate;
    private String txt;

    public Date getNotificationDate() {
        return notificationDate;
    }

    public void setNotificationDate(Date notificationDate) {
        this.notificationDate = notificationDate;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public String getStringCreationDate() {
        return creationDate.getHours()+":"+((creationDate.getMinutes()<10)? "0"+ creationDate.getMinutes() : creationDate.getMinutes())+" "+ creationDate.getDay()+"/"+ creationDate.getMonth()+"/"+(creationDate.getYear()+1900);
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public String getTxt() {
        return txt;
    }

    public void setTxt(String txt) {
        this.txt = txt;
    }
}
