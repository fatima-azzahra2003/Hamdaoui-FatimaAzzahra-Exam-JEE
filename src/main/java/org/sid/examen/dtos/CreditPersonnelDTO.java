package org.sid.examen.dtos;

import lombok.Data;
// DTO spécifique Crédit Personnel
@Data
public class CreditPersonnelDTO extends CreditDTO {
    private String motif;
}
