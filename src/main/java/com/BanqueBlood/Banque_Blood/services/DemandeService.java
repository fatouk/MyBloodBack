package com.BanqueBlood.Banque_Blood.services;

import com.BanqueBlood.Banque_Blood.model.Demande;

import java.util.List;

public interface DemandeService {
    Demande ajoutDemande(Demande demande);
    List<Demande> afficherListDemande();
    void supprimerDemande(Long id);
    Demande modifierDemande(Demande demande, Long id);
    Demande afficherDemandeById(Long id);
    List<Demande> afficherListDemandeByUser(Long id);
}
