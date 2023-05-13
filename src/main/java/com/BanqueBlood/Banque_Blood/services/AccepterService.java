package com.BanqueBlood.Banque_Blood.services;

import com.BanqueBlood.Banque_Blood.model.Accepter;
import com.BanqueBlood.Banque_Blood.model.Demande;
import com.BanqueBlood.Banque_Blood.model.Utilisateur;


import java.util.List;

public interface AccepterService {
    Accepter ajoutAccept(Accepter accepter);
    List<Accepter> afficherListAccept();
    List<Accepter> AcceptByUser(Long id);
    void supprimerAccept(Long id);
    Accepter modifierAccept(Accepter accepter, Long id);
    Accepter afficherAcceptById(Long id);
    Accepter afficherDemandeById(Demande demande);
    public  List<Accepter> afficherByEtat(boolean etat);
    public List<Accepter> afficherByAccepter(Utilisateur user);
    public List<Accepter> afficherByDemande(Long id);
    public  List<Accepter> afficherByEtatAndUser(Long id);

}
