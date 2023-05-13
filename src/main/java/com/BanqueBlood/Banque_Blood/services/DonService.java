package com.BanqueBlood.Banque_Blood.services;

import com.BanqueBlood.Banque_Blood.model.Don;

import java.util.List;

public interface DonService {
    Don ajoutDon(Don don);
    List<Don> afficherListDon();
    void supprimerDon(Long id);
    Don modifierDon(Don don, Long id);
    Don afficherDonById(Long id);
}
