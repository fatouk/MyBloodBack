package com.BanqueBlood.Banque_Blood.services;
import com.BanqueBlood.Banque_Blood.model.Accepter;
import com.BanqueBlood.Banque_Blood.model.Confirmer;
import com.BanqueBlood.Banque_Blood.model.Utilisateur;

import java.util.List;
public interface ConfirmerService {

    Confirmer ajoutConfirmer(Confirmer confirmer);
    List<Confirmer> afficherListConfirm();
    void supprimerConfirm(Long id);
    Confirmer modifierConfirm(Confirmer confirmer, Long id);
    Confirmer afficherConfirmById(Long id);
    Confirmer afficherConfirmerByAccepter(Accepter accepter);
    public  List<Confirmer> afficherConfirmByUser(Long id);
    public  List<Confirmer> afficherConfirmByAccept(Long id);
}
