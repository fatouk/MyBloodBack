package com.BanqueBlood.Banque_Blood.repository;

import com.BanqueBlood.Banque_Blood.model.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import java.util.List;

public interface AccepterRepository extends JpaRepository <Accepter, Long> {

    @Query(value = "Select a FROM Accepter a WHERE a.etat = false AND a.demande.utilisateur.id =:id")
    List<Accepter> AcceptByUser(@Param("id") Long id);



    List<Accepter> findByEtat(boolean etat);

    @Query("SELECT MAX(a) FROM Accepter a WHERE a.accepteur=:user")
    Accepter findByAccepterUser(@Param("user") Utilisateur utilisateur);
    Accepter findByDemande(Demande demande);

    List<Accepter> findByAccepteur(Utilisateur user);

    @Query(value = "SELECT ac FROM Accepter ac, Demande de, Utilisateur us WHERE ac.demande.id = de.id AND de.utilisateur.id = us.id AND us.id =:id")
    List<Accepter> findByAccepteurByDemande(@Param("id") Long id);

    @Query(value = "SELECT ac FROM Accepter ac, Demande  de, Utilisateur  us WHERE ac.etat=false AND ac.demande.id = de.id AND de.utilisateur.id = us.id AND us.id =:id")
    List<Accepter> findByEtatAndUser(@Param("id") Long id);
}
