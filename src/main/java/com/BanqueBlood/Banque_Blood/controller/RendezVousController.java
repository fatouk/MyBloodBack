package com.BanqueBlood.Banque_Blood.controller;

import com.BanqueBlood.Banque_Blood.model.Accepter;
import com.BanqueBlood.Banque_Blood.model.BanqueSang;
import com.BanqueBlood.Banque_Blood.model.RendezVous;
import com.BanqueBlood.Banque_Blood.services.BanqueSangService;
import com.BanqueBlood.Banque_Blood.services.RendezVousService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@CrossOrigin
@RequestMapping("/RendezVous")
public class RendezVousController {
    @Autowired
    RendezVousService rendezVousService;
    @PostMapping("/Ajout")
    RendezVous Ajout(@RequestBody RendezVous rendezVous){
        return  rendezVousService.ajoutRendezVous(rendezVous);

    }
    @GetMapping("/listRendez")
    List<RendezVous> listRendezVous()                  {
        return rendezVousService.listRendezVous();
    }
    @GetMapping("/ById/{id}")
    RendezVous RendezVousbyid(@PathVariable("id") Long id){
        return  rendezVousService.afficherbyid(id);
    }
    @DeleteMapping("/suprimerRendez/{id}")
    void supprimerBanque(@PathVariable("id") Long id){
        rendezVousService.suprimer(id);
    }
    @PutMapping("/modifierRendez/{id}")
    RendezVous modifierRendez(@PathVariable("id")Long id, @RequestBody RendezVous rendezVous){
        return rendezVousService.modifier(rendezVous, id);
    }
    @GetMapping("/detailRdv/{accepteur}")
    public RendezVous rendezVousByAccepteur(@PathVariable("accepteur") Long id) {
        return rendezVousService.findRendezVousByaccepter_id(id);
    }
}