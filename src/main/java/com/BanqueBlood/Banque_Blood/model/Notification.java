package com.BanqueBlood.Banque_Blood.model;

import javax.persistence.*;

@Entity
public class Notification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @ManyToOne
    private Demande demande;
    private  Integer nbreTotal;
    private boolean vue;
    @ManyToOne
    private  Utilisateur receveur;

    public Utilisateur getReceveur() {
        return receveur;
    }

    public void setReceveur(Utilisateur receveur) {
        this.receveur = receveur;
    }

    public boolean isVue() {
        return vue;
    }

    public void setVue(boolean vue) {
        this.vue = vue;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Demande getDemande() {
        return demande;
    }
    public void setDemande(Demande demande) {
        this.demande = demande;
    }
    public Integer getNbreTotal() {
        return nbreTotal;
    }
    public void setNbreTotal(Integer nbreTotal) {
        this.nbreTotal = nbreTotal;
    }
}
