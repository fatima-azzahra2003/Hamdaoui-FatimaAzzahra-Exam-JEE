package org.sid.jee_exam_backend.entities;


import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Entity
@DiscriminatorValue("PERSONNEL")
@Data @NoArgsConstructor @AllArgsConstructor @SuperBuilder
public class CreditPersonnel extends Credit {
    private String motif;
}