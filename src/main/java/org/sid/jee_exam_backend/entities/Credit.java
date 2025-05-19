package org.sid.jee_exam_backend.entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;
import java.util.Date;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="TYPE_CREDIT")
@Data @NoArgsConstructor @AllArgsConstructor @SuperBuilder
public abstract class Credit {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateDemande;
    private String statut;
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateAcception;
    private double montant;
    private int dureeRemboursement;
    private double tauxInteret;


    @ManyToOne
    private Client client;

    @OneToMany(mappedBy = "credit")
    private List<Remboursement> remboursements;
}