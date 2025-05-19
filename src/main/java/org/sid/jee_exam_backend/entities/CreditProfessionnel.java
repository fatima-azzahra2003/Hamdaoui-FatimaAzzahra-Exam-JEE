package org.sid.jee_exam_backend.entities;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Entity
@DiscriminatorValue("PROFESSIONNEL")
@Data @NoArgsConstructor @AllArgsConstructor @SuperBuilder
public class CreditProfessionnel extends Credit {
    private String motif;
    private String raisonSociale;
}