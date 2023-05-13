package com.BanqueBlood.Banque_Blood.repository;

import com.BanqueBlood.Banque_Blood.model.Accepter;
import com.BanqueBlood.Banque_Blood.model.Confirmer;
import com.BanqueBlood.Banque_Blood.model.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import java.util.List;
import java.util.Optional;

public interface ConfirmerRepository extends JpaRepository <Confirmer, Long> {
    Optional<Confirmer> findConfiremerByUtilisateur(Long id);
    Confirmer findByAccepter(Accepter accepter);

    @Query(value = "SELECT ac FROM Confirmer ac, Accepter  de, Utilisateur  us WHERE ac.etat='false' AND ac.accepter.id = de.id AND de.accepteur.id= us.id AND us.id =:id")
    List<Confirmer> findByEtatAndUser(@Param("id") Long id);

    @Query(value = "SELECT ac FROM Confirmer ac, Accepter de, Utilisateur us WHERE ac.accepter.id = de.id AND de.accepteur.id = us.id AND us.id =:id")
    List<Confirmer> findByAccepteurByConfirm(@Param("id") Long id);
}
