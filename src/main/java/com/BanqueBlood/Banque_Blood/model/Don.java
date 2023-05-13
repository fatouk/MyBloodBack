package com.BanqueBlood.Banque_Blood.model;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Entity
public class Don  implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    private LocalDate date = LocalDate.now();
    private LocalDate DateQuarantaine;
    @ManyToOne
    private  Confirmer confirmer;







    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDateQuarantaine() {
        return DateQuarantaine;
    }

    public void setDateQuarantaine(LocalDate dateQuarantaine) {
        DateQuarantaine = dateQuarantaine;
    }

    public Confirmer getConfirmer() {
        return confirmer;
    }

    public void setConfirmer(Confirmer confirmer) {
        this.confirmer = confirmer;
    }
}
