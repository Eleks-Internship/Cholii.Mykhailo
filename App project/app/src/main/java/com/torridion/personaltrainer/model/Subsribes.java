package com.torridion.personaltrainer.model;


import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class Subsribes extends RealmObject{

    @PrimaryKey
    private long id;
    private long idUser;
    private long idSubs;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getIdSubs() {
        return idSubs;
    }

    public void setIdSubs(long idSubs) {
        this.idSubs = idSubs;
    }

    public long getIdUser() {
        return idUser;
    }

    public void setIdUser(long idUser) {
        this.idUser = idUser;
    }
}
