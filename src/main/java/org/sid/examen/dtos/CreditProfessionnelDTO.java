package org.sid.examen.dtos;

import lombok.Data;
// DTO spécifique Crédit Professionnel
@Data
public class CreditProfessionnelDTO extends CreditDTO {
    private String motif;
    private String raisonSociale;
}
