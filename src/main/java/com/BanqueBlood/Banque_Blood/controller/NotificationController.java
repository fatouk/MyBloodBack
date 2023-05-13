package com.BanqueBlood.Banque_Blood.controller;
import com.BanqueBlood.Banque_Blood.model.Notification;
import com.BanqueBlood.Banque_Blood.model.Utilisateur;
import com.BanqueBlood.Banque_Blood.repository.NotificationRepository;
import com.BanqueBlood.Banque_Blood.services.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RequestMapping("/Notification")
@RestController
@CrossOrigin
public class NotificationController {
    @Autowired
    NotificationService notificationService;
    @Autowired
    NotificationRepository notifRp;
    @PostMapping("/Ajout")
    Notification Ajout(@RequestBody Notification notification){
        return  notificationService.ajoutNotif(notification);
    }
    @GetMapping("/listNotif")
    List<Notification> listNotif()                  {
        return notificationService.afficherListNotif();
    }
    @GetMapping("/ById/{id}")
    Notification Notifbyid(@PathVariable("id") Long id){
        return  notificationService.afficherNotifById(id);
    }
    @DeleteMapping("/suprimerNotif/{id}")
    void supprimerNotif(@PathVariable("id") Long id){
        notificationService.supprimerNotif(id);
    }
    @PutMapping("/modifierNotif/{id}")
    Notification modifierNotif(@PathVariable("id")Long id, @RequestBody Notification notification) {
        return  notificationService.modifierNotif(notification, id);
    }

    @PostMapping("/VueByUser/{vue}")
    List<Notification> VueByUser(@PathVariable("vue") boolean vue, @RequestBody Utilisateur user){
        System.out.println(user);
        return  notificationService.afficherByVueAndUser(vue , user);
    }
    @GetMapping("/NotifByUser/{id}")
    List<Notification> NotifByUser( @PathVariable("id") Utilisateur user){
        return  notificationService.afficherNotifByUser(user);
    }
}

