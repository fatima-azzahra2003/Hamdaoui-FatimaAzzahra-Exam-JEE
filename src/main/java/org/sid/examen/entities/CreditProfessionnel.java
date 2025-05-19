package org.sid.examen.entities;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.*;

@Entity
@DiscriminatorValue("PRO")
@Data @NoArgsConstructor @AllArgsConstructor
public class CreditProfessionnel extends Credit {
    private String motif;
    private String raisonSociale;
}
