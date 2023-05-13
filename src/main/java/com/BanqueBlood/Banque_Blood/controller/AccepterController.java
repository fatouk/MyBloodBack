package com.BanqueBlood.Banque_Blood.controller;

import com.BanqueBlood.Banque_Blood.model.Accepter;

import com.BanqueBlood.Banque_Blood.model.Confirmer;
import com.BanqueBlood.Banque_Blood.model.Demande;
import com.BanqueBlood.Banque_Blood.model.Utilisateur;
import com.BanqueBlood.Banque_Blood.services.AccepterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Accepter")
@CrossOrigin
public class AccepterController {
    @Autowired
    AccepterService accepterService;
    @PostMapping("/Ajout")
    Accepter Ajout(@RequestBody Accepter accepter){
        return  accepterService.ajoutAccept(accepter);
    }
    @GetMapping("/listAccept")
    List<Accepter> listAccepter()                  {
        return accepterService.afficherListAccept();
    }

    @GetMapping("/ById/{id}")
    Accepter AcceptById(@PathVariable("id") Long id){
        return  accepterService.afficherAcceptById(id);
    }

    @GetMapping("/AcceptByUser/{id}")
    List<Accepter> AcceptByUser(@PathVariable("id") Long id){
        return  accepterService.AcceptByUser(id);
    }

    @DeleteMapping("/deleteAccept/{id}")
    void deleteAccept(@PathVariable("id")Long id){
        accepterService.supprimerAccept(id);
    }

    @PutMapping("/modifierAccept/{id}")
    Accepter modifierAccept(@PathVariable("id")Long id, @RequestBody Accepter accepter){
        return accepterService.modifierAccept(accepter, id);
    }
    @PostMapping("/AcceptByDemande")
    Accepter acceptByDemande(@RequestBody Demande demande){
        return  accepterService.afficherDemandeById(demande);
    }

    @GetMapping("/ByEtat/{etat}")
    List<Accepter> acceptByEtat(@PathVariable("etat") boolean etat){
        return  accepterService.afficherByEtat(etat);
    }

    @GetMapping("/AcceptByUtilisateur/{id}")
    List<Accepter> afficherByUser(@PathVariable("id")Utilisateur user){

        return  accepterService.afficherByAccepter(user);

    }
    @GetMapping("/accepterByDemande/{id}")
    List<Accepter> accepterByDemande(@PathVariable("id") Long id){
        return accepterService.afficherByDemande(id);
    }
    @GetMapping("/accepterByEtatAndUser/{id}")
    List<Accepter> accepterByEtatAndUser(@PathVariable("id") Long id){
        return accepterService.afficherByEtatAndUser(id);
    }
}
