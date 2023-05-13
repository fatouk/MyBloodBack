package com.BanqueBlood.Banque_Blood.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;
@Entity
public class GroupeSanguin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;
    @Column(nullable = false)
    private String type;
    private String donne;
    private String recois;


    public GroupeSanguin() {
    }

    public GroupeSanguin(String type, String donne, String recois) {
        this.type = type;
        this.donne = donne;
        this.recois = recois;
    }

    public Long getId() {
        return id;
    }



    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDonne() {
        return donne;
    }

    public void setDonne(String donne) {
        this.donne = donne;
    }

    public String getRecois() {
        return recois;
    }

    public void setRecois(String recois) {
        this.recois = recois;
    }
}
