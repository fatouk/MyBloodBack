package com.BanqueBlood.Banque_Blood.controller;

import com.BanqueBlood.Banque_Blood.model.Don;
import com.BanqueBlood.Banque_Blood.services.DonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@CrossOrigin
@RequestMapping("/Don")
public class DonController {
    @Autowired
    DonService donService;
    @PostMapping("/Ajout")
    Don Ajout(@RequestBody Don don){
        return  donService.ajoutDon(don);
    }
    @GetMapping("/listDon")
    List<Don> listDon()                  {
        return donService.afficherListDon();
    }
    @GetMapping("/ById/{id}")
    Don Donbyid(@PathVariable("id") Long id){
        return  donService.afficherDonById(id);
    }
    @DeleteMapping("/suprimerDon/{id}")
    void supprimerDon(@PathVariable("id") Long id){
        donService.supprimerDon(id);
    }
    @PutMapping("/modifierDon/{id}")
    Don modifierDon(@PathVariable("id")Long id, @RequestBody Don don) {
      return  donService.modifierDon(don, id);
    }
}
