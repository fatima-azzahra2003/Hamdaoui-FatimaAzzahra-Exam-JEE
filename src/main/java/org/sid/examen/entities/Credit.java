package org.sid.examen.entities;

import jakarta.persistence.*;
import lombok.*;
import org.sid.examen.enums.StatutCredit;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "TYPE_CREDIT")
@Data @NoArgsConstructor @AllArgsConstructor
public abstract class Credit {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date dateDemande;
    @Enumerated(EnumType.STRING)
    private StatutCredit statut;
    private Date dateAcception;
    private double montant;
    private int dureeRemboursement; // en mois
    private double tauxInteret;

    @ManyToOne
    private Client client;

    @OneToMany(mappedBy = "credit", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Remboursement> remboursements = new ArrayList<>();

}

