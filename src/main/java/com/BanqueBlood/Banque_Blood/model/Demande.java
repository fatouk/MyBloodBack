package com.BanqueBlood.Banque_Blood.model;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Collection;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class Demande implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    private  int nbrepoche ;
    

    @ManyToOne
    private Utilisateur utilisateur;
    private String NomHopital;

    @ManyToOne
    private GroupeSanguin groupeSanguin;

    private LocalDate date = LocalDate.now();
}


