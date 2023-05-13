package com.BanqueBlood.Banque_Blood.serviceImp;

import com.BanqueBlood.Banque_Blood.model.Accepter;
import com.BanqueBlood.Banque_Blood.model.RendezVous;
import com.BanqueBlood.Banque_Blood.repository.RendezVousRepository;
import com.BanqueBlood.Banque_Blood.services.RendezVousService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RendezVousServiceImp implements RendezVousService {
    @Autowired
    RendezVousRepository rendezVousRepository;


    @Override
    public RendezVous findRendezVousByaccepter_id(Long id) {
        return rendezVousRepository.findRendezVousByaccepter_id(id);
    }

    @Override
    public RendezVous ajoutRendezVous(RendezVous rendezVous) {
        return rendezVousRepository.save(rendezVous);
    }

    @Override
    public List<RendezVous> listRendezVous() {
        return rendezVousRepository.findAll();
    }

    @Override
    public RendezVous afficherbyid(Long id) {
        return rendezVousRepository.findById(id).get();
    }

    @Override
    public RendezVous modifier(RendezVous rendezVous, Long id) {
        RendezVous rendezVous1 = rendezVousRepository.findById(id).get();
       rendezVous1.setBanqueSang(rendezVous.getBanqueSang());
       rendezVous1.setAccepter(rendezVous.getAccepter());
        rendezVous1.setDate(rendezVous.getDate());
       rendezVous1.setHeure(rendezVous.getHeure());
       rendezVous1.setQtepoche(rendezVous.getQtepoche());
       rendezVous1.setPoids(rendezVous.getPoids());
        return rendezVousRepository.save(rendezVous1);
    }

    @Override
    public void suprimer(Long id) {
        rendezVousRepository.deleteById(id);

    }
}
