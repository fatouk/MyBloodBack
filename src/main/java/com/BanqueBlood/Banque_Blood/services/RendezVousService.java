package com.BanqueBlood.Banque_Blood.services;

import com.BanqueBlood.Banque_Blood.model.Accepter;
import com.BanqueBlood.Banque_Blood.model.BanqueSang;
import com.BanqueBlood.Banque_Blood.model.RendezVous;

import java.util.List;

public interface RendezVousService {
    RendezVous findRendezVousByaccepter_id(Long id);
    RendezVous ajoutRendezVous(RendezVous rendezVous);
    List<RendezVous> listRendezVous();
    RendezVous afficherbyid(Long id);
    RendezVous modifier(RendezVous rendezVous , Long id);
    void suprimer(Long id);
}
