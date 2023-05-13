package com.BanqueBlood.Banque_Blood.serviceImp;


import com.BanqueBlood.Banque_Blood.model.GroupeSanguin;
import com.BanqueBlood.Banque_Blood.repository.GroupeSanguinRepository;
import com.BanqueBlood.Banque_Blood.services.GroupeSanguinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GroupeSanguinServiceImp implements GroupeSanguinService {
    @Autowired
    GroupeSanguinRepository groupeSanguinRepository;
    @Override
    public GroupeSanguin ajoutGroupe(GroupeSanguin groupeSanguin) {
        return groupeSanguinRepository.save(groupeSanguin);
    }

    @Override
    public List<GroupeSanguin> afficherListGroupe() {
        return groupeSanguinRepository.findAll();
    }

    @Override
    public void supprimerGroupe(Long id) {
        groupeSanguinRepository.deleteById(id);

    }

    @Override
    public GroupeSanguin modifierGroupe(GroupeSanguin groupeSanguin , Long id) {
        GroupeSanguin groupeSanguin1 = groupeSanguinRepository.findById(id).get();
        groupeSanguin1.setType(groupeSanguin.getType());
       groupeSanguin1.setDonne(groupeSanguin.getDonne());
       groupeSanguin1.setRecois(groupeSanguin.getRecois());
        return groupeSanguinRepository.save(groupeSanguin1);
    }

    @Override
    public GroupeSanguin afficherGroupeById(Long id) {
        return groupeSanguinRepository.findById(id).get();
    }
}
