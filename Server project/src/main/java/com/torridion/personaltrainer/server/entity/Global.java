package com.torridion.personaltrainer.server.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "global")
public class Global {

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    private short id;

    @Column(name = "users")
    private long users;

    @Column(name = "prusiadov")
    private long prusiadov;

    @Column(name = "vidjuman")
    private long vidjuman;

    @Column(name = "pidtiaguvan")
    private long pidtiaguvan;

    @Column(name = "press")
    private long press;

    @Column(name = "big")
    private long big;

    @Column(name = "guria")
    private long guria;

    @Column(name = "skakalka")
    private long skakalka;

    @Column(name = "gum_leja")
    private long gumLeja;

    @Column(name = "prys_zsht")
    private long prysZSht;

    @Column(name = "ganteli")
    private long ganteli;

    @Column(name = "stanova")
    private long stanova;

    @Column(name = "t_velo")
    private long tVelo;

    @Column(name = "t_vaga")
    private long tVaga;

    @Column(name = "t_dorijka")
    private long tDorijka;

    public Global() {
    }

    public long getUsers() {
        return users;
    }

    public void setUsers(long users) {
        this.users = users;
    }

    public long getPrusiadov() {
        return prusiadov;
    }

    public void setPrusiadov(long prusiadov) {
        this.prusiadov = prusiadov;
    }

    public long getVidjuman() {
        return vidjuman;
    }

    public void setVidjuman(long vidjuman) {
        this.vidjuman = vidjuman;
    }

    public long getPidtiaguvan() {
        return pidtiaguvan;
    }

    public void setPidtiaguvan(long pidtiaguvan) {
        this.pidtiaguvan = pidtiaguvan;
    }

    public long getPress() {
        return press;
    }

    public void setPress(long press) {
        this.press = press;
    }

    public long getBig() {
        return big;
    }

    public void setBig(long big) {
        this.big = big;
    }

    public long getGuria() {
        return guria;
    }

    public void setGuria(long guria) {
        this.guria = guria;
    }

    public long getSkakalka() {
        return skakalka;
    }

    public void setSkakalka(long skakalka) {
        this.skakalka = skakalka;
    }

    public long getGumLeja() {
        return gumLeja;
    }

    public void setGumLeja(long gumLeja) {
        this.gumLeja = gumLeja;
    }

    public long getPrysZSht() {
        return prysZSht;
    }

    public void setPrysZSht(long prysZSht) {
        this.prysZSht = prysZSht;
    }

    public long getGanteli() {
        return ganteli;
    }

    public void setGanteli(long ganteli) {
        this.ganteli = ganteli;
    }

    public long getStanova() {
        return stanova;
    }

    public void setStanova(long stanova) {
        this.stanova = stanova;
    }

    public long gettVelo() {
        return tVelo;
    }

    public void setVelo(long tVelo) {
        this.tVelo = tVelo;
    }

    public long gettVaga() {
        return tVaga;
    }

    public void setVaga(long tVaga) {
        this.tVaga = tVaga;
    }

    public long gettDorijka() {
        return tDorijka;
    }

    public void setDorijka(long tDorijka) {
        this.tDorijka = tDorijka;
    }
}
