package com.BanqueBlood.Banque_Blood.model;
import com.BanqueBlood.Banque_Blood.Profils;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Utilisateur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nomComplet;

    @Column(nullable = false)
    private String adresse;

    @Column(nullable = false, unique = true)
    private String telephone;

    @Column(nullable = false)
    private String password;

    @Enumerated
    private Profils profils;

    @ManyToOne
    private GroupeSanguin groupeSanguin;

    @ManyToOne
    private Admin admin;
    @OneToMany
    private List<Demande> demande;
}
