package com.torridion.personaltrainer.server.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "subscribes")
public class Subscribes {

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    private long id;

    @Column(name = "iduser", nullable = false)
    private long idUser;

    @Column(name = "idsubs", nullable = false)
    private long idSubs;

    public Subscribes() {
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

    public long getIdSubs() {
        return idSubs;
    }

    public void setIdSubs(long idSubs) {
        this.idSubs = idSubs;
    }
}
