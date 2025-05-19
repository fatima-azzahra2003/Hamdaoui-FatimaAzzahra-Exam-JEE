package org.sid.jee_exam_backend.dtos;

import lombok.Data;

@Data
public class CreditImmobilierDTO extends CreditDTO {
    private String typeBien;
}