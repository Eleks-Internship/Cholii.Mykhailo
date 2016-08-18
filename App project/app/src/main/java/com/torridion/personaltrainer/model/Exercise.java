package com.torridion.personaltrainer.model;


import java.util.Date;

import io.realm.RealmObject;

public class Exercise extends RealmObject{

    private Date date;
    private int idExerciseType;
    private int kilkist;
    private int kg;
    private int m;
    private int time;
    private int speed;


    public String getDate() {
        return date.getHours()+":"+((date.getMinutes()<10)? "0"+date.getMinutes() : date.getMinutes())+" "+date.getDay()+"/"+date.getMonth()+"/"+(date.getYear()+1900);
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getIdExerciseType() {
        return idExerciseType;
    }

    public void setIdExerciseType(int idExerciseType) {
        this.idExerciseType = idExerciseType;
    }

    public int getKg() {
        return kg;
    }

    public void setKg(int kg) {
        this.kg = kg;
    }

    public int getKilkist() {
        return kilkist;
    }

    public void setKilkist(int kilkist) {
        this.kilkist = kilkist;
    }

    public int getM() {
        return m;
    }

    public void setM(int m) {
        this.m = m;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }
}
