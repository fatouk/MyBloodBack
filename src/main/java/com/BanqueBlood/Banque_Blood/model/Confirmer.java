package com.BanqueBlood.Banque_Blood.model;



import javax.persistence.*;
import java.time.LocalDate;


@Entity
public class Confirmer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate date = LocalDate.now();
    private String etat;
    private LocalDate dateQuarantaine;

    @ManyToOne
    private Accepter accepter;
    @ManyToOne
    private Utilisateur utilisateur;


    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }







    public void setId(Long id) {
        this.id = id;
    }

    public Accepter getAccepter() {
        return accepter;
    }

    public void setAccepter(Accepter accepter) {
        this.accepter = accepter;
    }

    public Long getId() {
        return id;
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    public LocalDate getDateQuarantaine() {
        return dateQuarantaine;
    }

    public void setDateQuarantaine(LocalDate dateQuarantaine) {
        this.dateQuarantaine = dateQuarantaine;
    }


}
