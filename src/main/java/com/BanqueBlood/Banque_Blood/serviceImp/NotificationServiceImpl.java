package com.BanqueBlood.Banque_Blood.serviceImp;
import com.BanqueBlood.Banque_Blood.model.Notification;
import com.BanqueBlood.Banque_Blood.model.Utilisateur;
import com.BanqueBlood.Banque_Blood.repository.NotificationRepository;
import com.BanqueBlood.Banque_Blood.services.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
@Service
public class NotificationServiceImpl  implements NotificationService {
    @Autowired
    NotificationRepository notificationRepository ;
    @Override
    public Notification ajoutNotif(Notification notification) {
        return notificationRepository.save(notification);
    }
    @Override
    public List<Notification> afficherListNotif() {
        return notificationRepository.findAll();
    }
    @Override
    public void supprimerNotif(Long id) {
        notificationRepository.findById(id).get();
    }
    @Override
    public Notification modifierNotif(Notification notification, Long id) {
        Notification notification1 = notificationRepository.findById(id).get();
        notification1.setDemande(notification.getDemande());
       notification1.setNbreTotal(notification.getNbreTotal());
       notification1.setVue(notification.isVue());
        return notificationRepository.save(notification1);
    }
    @Transactional
    @Override
    public Notification afficherNotifById(Long id) {
        Notification notification = notificationRepository.findById(id).get();
        notification.setVue(true);
        return notificationRepository.findById(id).get();
    }

    @Override
    public List<Notification> afficherByVueAndUser(boolean vue, Utilisateur u) {
        return notificationRepository.findByVueAndReceveur(false, u);
    }

    @Override
    public List<Notification> afficherNotifByUser(Utilisateur user) {
        return notificationRepository.findByReceveur(user);
    }
}

