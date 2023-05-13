package com.BanqueBlood.Banque_Blood.controller;
import com.BanqueBlood.Banque_Blood.model.Accepter;
import com.BanqueBlood.Banque_Blood.model.Confirmer;
import com.BanqueBlood.Banque_Blood.services.ConfirmerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Confirmer")
@CrossOrigin
public class ConfirmerController {
    @Autowired
    ConfirmerService confirmerService;
    @PostMapping("/Ajout")
    Confirmer Ajout(@RequestBody Confirmer confirmer){
        return  confirmerService.ajoutConfirmer(confirmer);
    }
    @GetMapping("/listConfirmer")
    List<Confirmer> listConfirm()                  {
        return confirmerService.afficherListConfirm();
    }
    @GetMapping("/ById/{id}")
    Confirmer ConfirmById(@PathVariable("id") Long id){
        return  confirmerService.afficherConfirmById(id);
    }

    @DeleteMapping("/deleteConfirmer/{id}")
    void deleteConfirm(@PathVariable("id")Long id){
        confirmerService.supprimerConfirm(id);
    }
    @PutMapping("/modifierConfirmer/{id}")
    Confirmer modifierConfirm(@PathVariable("id")Long id, @RequestBody Confirmer confirmer){
        return confirmerService.modifierConfirm(confirmer, id);
    }
    @PostMapping("/ConfirmByUser")
    Confirmer confirmerByUser(@RequestBody Accepter accepter){
        return  confirmerService.afficherConfirmerByAccepter(accepter);
    }

    @GetMapping("/confirmByEtatAndUser/{id}")
    List<Confirmer> confirmByEtatAndUser(@PathVariable("id") Long id){
        return  confirmerService.afficherConfirmByUser(id);
    }
    @GetMapping("/confirmByUser/{id}")
    List<Confirmer> confirmByDemande(@PathVariable("id") Long id){
        return confirmerService.afficherConfirmByAccept(id);
    }


}
