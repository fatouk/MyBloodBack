package com.BanqueBlood.Banque_Blood.serviceImp;

import com.BanqueBlood.Banque_Blood.Profils;
import com.BanqueBlood.Banque_Blood.exceptions.EntityNotFound;
import com.BanqueBlood.Banque_Blood.exceptions.ErrorsCode;
import com.BanqueBlood.Banque_Blood.exceptions.InvalidEntity;

import com.BanqueBlood.Banque_Blood.model.Utilisateur;
import com.BanqueBlood.Banque_Blood.repository.UtilsateursRepository;
import com.BanqueBlood.Banque_Blood.services.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class UtilisateursServiceImp  implements UtilisateurService  {
    @Autowired
    UtilsateursRepository utilsateursRepository ;


    @Override
    public Utilisateur ajoutUtilisateur(Utilisateur utilisateur)
    {
    Optional<Utilisateur> user= utilsateursRepository.findByTelephone(utilisateur.getTelephone());
     if(!user.isEmpty()){
        //return null;
    throw  new EntityNotFound("votre numero de telephone existe dejà", ErrorsCode.UTILISATEUR_EXIST_DEJA);
 }

        return utilsateursRepository.save(utilisateur);
    }

    @Override
    public List<Utilisateur> listUtilisateur() {
        return utilsateursRepository.findAll();
    }



    @Override
    public Utilisateur afficherbyid(Long id) {
        return utilsateursRepository.findById(id).get();
    }

    @Override
    public Utilisateur modifier(Utilisateur utilisateur, Long id) {
        Utilisateur utilisateur1=utilsateursRepository.findById(id).get();
        utilisateur1.setNomComplet(utilisateur.getNomComplet());
        utilisateur1.setTelephone(utilisateur.getTelephone());
        utilisateur1.setAdresse(utilisateur.getAdresse());
        utilisateur1.setPassword(utilisateur.getPassword());

        return utilsateursRepository.save(utilisateur1);
    }

    @Override
    public void suprimer(Long id) {
        utilsateursRepository.deleteById(id);
    }

    @Override
    public Utilisateur login(String telephone, String password) {
        Optional<Utilisateur> phone= utilsateursRepository.findByTelephone(telephone);
        Optional<Utilisateur> donneurConnexion = utilsateursRepository.findByTelephoneAndPassword(telephone,password);
   if(donneurConnexion.isEmpty()){
       throw new InvalidEntity("login ou mot de passe est incorrecte", ErrorsCode.UTILISATEUR_AUTHENTIFICATION_INVALID);
   }
   if(phone.isEmpty()){
       throw new InvalidEntity("telephone incorecte", ErrorsCode.UTILISATEUR_AUTHENTIFICATION_INVALID);
   }



        return donneurConnexion.get();
    }

    @Override
    public List<Utilisateur> afficherByTelephone(String telephone) {
        return  utilsateursRepository.findByTelephoneNot(telephone);
    }


}
