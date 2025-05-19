package org.sid.examen.entities;

import jakarta.persistence.*;
import lombok.*;
import org.sid.examen.enums.TypeRemboursement;

import java.util.Date;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class Remboursement {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date date;
    private double montant;
    @Enumerated(EnumType.STRING)
    private TypeRemboursement type;

    @ManyToOne
    @JoinColumn(name = "credit_id")
    private Credit credit;

}
