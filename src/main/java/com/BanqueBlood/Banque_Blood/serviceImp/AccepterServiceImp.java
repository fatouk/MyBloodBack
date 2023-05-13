package com.BanqueBlood.Banque_Blood.serviceImp;

import com.BanqueBlood.Banque_Blood.model.Accepter;
import com.BanqueBlood.Banque_Blood.model.Demande;
import com.BanqueBlood.Banque_Blood.model.Utilisateur;
import com.BanqueBlood.Banque_Blood.repository.AccepterRepository;
import com.BanqueBlood.Banque_Blood.services.AccepterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
@Service
public class AccepterServiceImp implements AccepterService {
    @Autowired
    AccepterRepository accepterRepository ;
    @Autowired

    DonServiceImp donServiceImp;

    @Override
    public Accepter ajoutAccept(Accepter accepter) {
        Accepter accepter1 = accepterRepository.findByAccepterUser(accepter.getAccepteur());

        if(accepter1 == null)
        {
            accepter.setDateQuarantaine(accepter.getDate().plusMonths(3));
            return  accepterRepository.save(accepter);
        }

        if(accepter1.getDateQuarantaine().isAfter(accepter.getDate()))
        {

            return null;
            //throw new EntityNotFound("votre dernier don ne vaut pas 3 mois", ErrorsCode.DON_INVALID);
        }
        accepter.setEtat(false);
        accepter.setDateQuarantaine(accepter.getDate().plusMonths(3));
        return  accepterRepository.save(accepter);
    }

    @Override
    public List<Accepter> afficherListAccept() {
        return accepterRepository.findAll();
    }

    @Override
    public List<Accepter> AcceptByUser(Long id) {
        return accepterRepository.AcceptByUser(id);
    }

    @Override
    public void supprimerAccept(Long id) {
        accepterRepository.deleteById(id);

    }

    @Override
    public Accepter modifierAccept(Accepter accepter, Long id) {
        Accepter accepter1 = accepterRepository.findById(id).get();
        accepter1.setAccepteur(accepter.getAccepteur());
        accepter1.setDate(accepter.getDate());
        accepter1.setDemande(accepter.getDemande());


        return accepterRepository.save(accepter1);
    }

    @Transactional
    @Override
    public Accepter afficherAcceptById(Long id) {

        Accepter accepter = accepterRepository.findById(id).get();
        accepter.setEtat(true);
        return accepterRepository.findById(id).get();
    }

    @Override
    public Accepter afficherDemandeById(Demande demande) {
        return accepterRepository.findByDemande(demande);
    }

    @Override
    public List<Accepter> afficherByEtat(boolean etat) {
        return accepterRepository.findByEtat(etat);
    }

    @Override
    public List<Accepter> afficherByAccepter(Utilisateur user) {
        return accepterRepository.findByAccepteur(user);
    }

    @Override
    public List<Accepter> afficherByDemande(Long id) {
        return accepterRepository.findByAccepteurByDemande(id);
    }

    @Override
    public List<Accepter> afficherByEtatAndUser(Long id) {
        return accepterRepository.findByEtatAndUser(id);
    }
}
