package com.BanqueBlood.Banque_Blood.serviceImp;

import com.BanqueBlood.Banque_Blood.model.Confirmer;
import com.BanqueBlood.Banque_Blood.model.Don;
import com.BanqueBlood.Banque_Blood.model.Utilisateur;
import com.BanqueBlood.Banque_Blood.repository.DonRepository;
import com.BanqueBlood.Banque_Blood.services.DonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;
@Service
public class DonServiceImp implements DonService {
    @Autowired
    DonRepository donRepository;
    @Override
    public Don ajoutDon(Don don) {
        return donRepository.save(don);
    }

    @Override
    public List<Don> afficherListDon() {
        return donRepository.findAll();
    }

    @Override
    public void supprimerDon(Long id) {
        donRepository.findById(id).get();

    }

    @Override
    public Don modifierDon(Don don, Long id) {
        Don don1 = donRepository.findById(id).get();
        don1.setDate(don.getDate());
        don1.setConfirmer(don.getConfirmer());
        don1.setDateQuarantaine(don.getDateQuarantaine());
        return donRepository.save(don1);
    }

    @Override
    public Don afficherDonById(Long id) {
        return donRepository.findById(id).get();
    }



}
