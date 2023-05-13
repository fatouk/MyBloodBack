package com.BanqueBlood.Banque_Blood.services;
import com.BanqueBlood.Banque_Blood.model.Notification;
import com.BanqueBlood.Banque_Blood.model.Utilisateur;

import java.util.List;
public interface NotificationService {
    Notification ajoutNotif(Notification notification);
    List<Notification> afficherListNotif();
    void supprimerNotif(Long id);
    Notification modifierNotif(Notification notification, Long id);
    Notification afficherNotifById(Long id);
    public List<Notification> afficherByVueAndUser(boolean vue, Utilisateur u);
    public List<Notification> afficherNotifByUser(Utilisateur user);
}

