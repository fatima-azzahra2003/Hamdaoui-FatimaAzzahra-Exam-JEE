package org.sid.jee_exam_backend.dtos;

import lombok.Data;
import java.util.Date;

@Data
public class RemboursementDTO {
    private Long id;
    private Date date;
    private double montant;
    private String type;
    private Long creditId;
}