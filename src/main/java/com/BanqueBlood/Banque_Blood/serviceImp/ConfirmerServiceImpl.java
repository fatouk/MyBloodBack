package com.BanqueBlood.Banque_Blood.serviceImp;

import com.BanqueBlood.Banque_Blood.model.Accepter;
import com.BanqueBlood.Banque_Blood.model.Confirmer;
import com.BanqueBlood.Banque_Blood.model.Don;
import com.BanqueBlood.Banque_Blood.repository.ConfirmerRepository;
import com.BanqueBlood.Banque_Blood.services.ConfirmerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ConfirmerServiceImpl implements ConfirmerService {
    @Autowired
    ConfirmerRepository confirmerRepository;
    @Autowired
    DonServiceImp donServiceImp;

    @Transactional
    @Override
    public Confirmer ajoutConfirmer(Confirmer confirmer) {
        Don newDon = new Don();
        confirmerRepository.save(confirmer);
        newDon.setDate(confirmer.getDate());
        newDon.setConfirmer(confirmer);
        newDon.setDateQuarantaine(confirmer.getDate().plusMonths(3));
        donServiceImp.ajoutDon(newDon);
        confirmer.setDateQuarantaine(confirmer.getDate().plusMonths(3));

        return  confirmerRepository.save(confirmer);
    }

    @Override
    public List<Confirmer> afficherListConfirm() {
        return confirmerRepository.findAll();
    }

    @Override
    public void supprimerConfirm(Long id) {
        confirmerRepository.findById(id).get();

    }

    @Override
    public Confirmer modifierConfirm(Confirmer confirmer, Long id) {

        Confirmer confirmer1 = confirmerRepository.findById(id).get();
        confirmer1.setUtilisateur(confirmer.getUtilisateur());
        confirmer1.setDate(confirmer.getDate());
       confirmer1.setAccepter(confirmer.getAccepter());

       confirmer1.setDateQuarantaine(confirmer.getDate().plusMonths(3));


        return null;
    }

    @Override
    public Confirmer afficherConfirmById(Long id) {
        Confirmer confirmer = confirmerRepository.findById(id).get();
        confirmer.setEtat("lu");
        return confirmerRepository.save(confirmer);
    }

    @Override
    public Confirmer afficherConfirmerByAccepter(Accepter accepter) {
        return confirmerRepository.findByAccepter(accepter);
    }

    @Override
    public List<Confirmer> afficherConfirmByUser(Long id) {
        return confirmerRepository.findByEtatAndUser(id);
    }

    @Override
    public List<Confirmer> afficherConfirmByAccept(Long id) {
        return confirmerRepository.findByAccepteurByConfirm(id);
    }
}
