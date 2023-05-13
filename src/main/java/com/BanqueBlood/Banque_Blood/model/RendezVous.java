package com.BanqueBlood.Banque_Blood.model;

import javax.persistence.*;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;

@Entity
public class RendezVous {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;
    @Column(nullable = false)
    private LocalDate date;
    private LocalTime heure;
    private int qtepoche;
    private int poids;
    @ManyToOne
   private Accepter accepter;

@ManyToOne
private BanqueSang banqueSang;


    public RendezVous() {

    }





    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getHeure() {
        return heure;
    }

    public void setHeure(LocalTime heure) {
        this.heure = heure;
    }

    public BanqueSang getBanqueSang() {
        return banqueSang;
    }

    public Accepter getAccepter() {
        return accepter;
    }

    public void setAccepter(Accepter accepter) {
        this.accepter = accepter;
    }

    public void setBanqueSang(BanqueSang banqueSang) {
        this.banqueSang = banqueSang;
    }

    public int getQtepoche() {
        return qtepoche;
    }

    public void setQtepoche(int qtepoche) {
        this.qtepoche = qtepoche;
    }

    public int getPoids() {
        return poids;
    }

    public void setPoids(int poids) {
        this.poids = poids;
    }
}
