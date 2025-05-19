package org.sid.examen.dtos;

import lombok.Data;
// DTO spécifique Crédit Immobilier
@Data
public class CreditImmobilierDTO extends CreditDTO {
    private String typeBien; // String pour exposer l'enum comme texte
}
