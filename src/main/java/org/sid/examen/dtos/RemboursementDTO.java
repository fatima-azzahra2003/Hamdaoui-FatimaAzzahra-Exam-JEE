package org.sid.examen.dtos;

import lombok.Data;

import java.util.Date;

@Data
public class RemboursementDTO {
    private Long id;
    private Date date;
    private double montant;
    private String type; // exposer l'enum en String
    private Long creditId;
}
