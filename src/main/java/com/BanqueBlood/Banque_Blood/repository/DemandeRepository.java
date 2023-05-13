package com.BanqueBlood.Banque_Blood.repository;
import com.BanqueBlood.Banque_Blood.model.Demande;
import com.BanqueBlood.Banque_Blood.model.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DemandeRepository extends JpaRepository<Demande, Long> {
   List<Demande>  findByUtilisateurNot(Utilisateur user);
   List<Demande>  findByUtilisateur(Utilisateur user);
}
