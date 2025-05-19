package org.sid.examen.entities;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.*;

@Entity
@DiscriminatorValue("PERS")
@Data @NoArgsConstructor @AllArgsConstructor
public class CreditPersonnel extends Credit {
    private String motif; // exemple : achat voiture, études...
}
