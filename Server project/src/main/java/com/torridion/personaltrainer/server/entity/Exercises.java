package com.torridion.personaltrainer.server.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "exercises")
public class Exercises {

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    private long id;

    @Column(name = "iduser")
    private long idUser;

    @Column(name = "idex")
    private long idEx;

    @Column(name = "date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;

    @Column(name = "kilkist")
    private int kilkist;

    @Column(name = "kg")
    private float kg;

    @Column(name = "m")
    private int m;

    @Column(name = "time_sec")
    private int timeSec;

    public Exercises() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getIdUser() {
        return idUser;
    }

    public void setIdUser(long idUser) {
        this.idUser = idUser;
    }

    public long getIdEx() {
        return idEx;
    }

    public void setIdEx(long idEx) {
        this.idEx = idEx;
    }

    public int getKilkist() {
        return kilkist;
    }

    public void setKilkist(int kilkist) {
        this.kilkist = kilkist;
    }

    public float getKg() {
        return kg;
    }

    public void setKg(float kg) {
        this.kg = kg;
    }

    public int getM() {
        return m;
    }

    public void setM(int m) {
        this.m = m;
    }

    public int getTimeSec() {
        return timeSec;
    }

    public void setTimeSec(int timeSec) {
        this.timeSec = timeSec;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
