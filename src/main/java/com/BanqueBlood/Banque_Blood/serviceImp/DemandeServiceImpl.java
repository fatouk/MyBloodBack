package com.BanqueBlood.Banque_Blood.serviceImp;

import com.BanqueBlood.Banque_Blood.model.Demande;
import com.BanqueBlood.Banque_Blood.model.Notification;
import com.BanqueBlood.Banque_Blood.model.Utilisateur;
import com.BanqueBlood.Banque_Blood.repository.DemandeRepository;
import com.BanqueBlood.Banque_Blood.repository.NotificationRepository;
import com.BanqueBlood.Banque_Blood.repository.UtilsateursRepository;
import com.BanqueBlood.Banque_Blood.services.DemandeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
@Service
public class DemandeServiceImpl implements DemandeService {
    @Autowired
    DemandeRepository demandeRepository;
    @Autowired
    NotificationRepository notificationRepository;

    @Autowired
    UtilsateursRepository utilsateursRepository;

    @Transactional
    @Override
    public Demande ajoutDemande(Demande demande) {

       /* Vue vue = new Vue();
        vue.setUtilisateur(demande.getUtilisateur());
        vueService.addVue(vue);
        demande.setVue(vue);

        */

        Demande demande1 = demandeRepository.save(demande);
       /* System.out.println("Groupe sanguin : " +demande1.getGroupeSanguin().toString());
        Long id = demande1.getId();
        demande1.setVue(demande1.getVue());
        Vue vue1 = demande1.getVue();
        vue1.setDemande(demande1);
        vueService.editVue(demande1.getVue().getId(), demande1.getVue());
        */
        List<Utilisateur> utilisateurs = new ArrayList<>();
        utilisateurs=utilsateursRepository.findByIdNot(demande.getUtilisateur().getId());
        System.out.println(utilisateurs.size());
        /*List<Demande> listdemandes = new ArrayList<>();
        listdemandes= demandeRepository.findByUtilisateurNot(demande.getUtilisateur());
        for(Demande d:listdemandes){

            if(!utilisateurs.contains(d.getUtilisateur())){
                utilisateurs.add(d.getUtilisateur());
                System.out.println("cet element existe");
            }
        }

         */

        for (Utilisateur u : utilisateurs) {
            Notification notification = new Notification();
            notification.setDemande(demande);
            notification.setNbreTotal(0);
            notification.setVue(false);
            notification.setReceveur(u);
            notificationRepository.save(notification);
        }


        return demande1;
    }

    @Override
    public List<Demande> afficherListDemande() {
        return demandeRepository.findAll();
    }

    @Override
    public void supprimerDemande(Long id) {
        demandeRepository.deleteById(id);
    }

    @Override
    public Demande modifierDemande(Demande demande, Long id) {
        Demande  demande1 = demandeRepository.findById(id).get();
        demande1.setDate(demande.getDate());
        demande1.setNbrepoche(demande.getNbrepoche());
        demande1.setNomHopital(demande.getNomHopital());
        return demandeRepository.save(demande1);
    }

    @Override
    public Demande afficherDemandeById(Long id) {
        return demandeRepository.findById(id).get();
    }
    @Override
    public List<Demande> afficherListDemandeByUser(Long id) {
        Utilisateur u=utilsateursRepository.getById(id);
        return demandeRepository.findByUtilisateur(u);
    }
}
