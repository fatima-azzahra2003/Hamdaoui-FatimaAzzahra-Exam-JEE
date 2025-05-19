package org.sid.examen.entities;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.EnumType;
import lombok.*;
import org.sid.examen.enums.TypeImmobilier;

@Entity
@DiscriminatorValue("IMMO")
@Data @NoArgsConstructor @AllArgsConstructor
public class CreditImmobilier extends Credit {

    @Enumerated(EnumType.STRING)
    private TypeImmobilier typeBien; // APPARTEMENT, MAISON, LOCAL_COMMERCIAL
}
