package com.BanqueBlood.Banque_Blood.repository;

import com.BanqueBlood.Banque_Blood.model.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UtilsateursRepository extends JpaRepository <Utilisateur, Long> {
    Optional<Utilisateur> findByTelephoneAndPassword(String telephone, String password);
    Optional<Utilisateur> findByTelephone(String telephone);
    List<Utilisateur> findByTelephoneNot(String telephone);
    List<Utilisateur> findByIdNot(Long id);
}
