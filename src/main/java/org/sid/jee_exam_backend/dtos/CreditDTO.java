package org.sid.jee_exam_backend.dtos;

import lombok.Data;
import java.util.Date;

@Data
public class CreditDTO {
    private Long id;
    private Date dateDemande;
    private String statut;
    private Date dateAcception;
    private double montant;
    private int dureeRemboursement;
    private double tauxInteret;
    private Long clientId;
}
