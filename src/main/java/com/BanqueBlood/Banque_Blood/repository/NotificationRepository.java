package com.BanqueBlood.Banque_Blood.repository;

import com.BanqueBlood.Banque_Blood.model.Notification;
import com.BanqueBlood.Banque_Blood.model.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NotificationRepository extends JpaRepository<Notification, Long > {

    List<Notification> findByVueAndReceveur(boolean vue , Utilisateur u);

    List<Notification> findByReceveur(Utilisateur user);

}
