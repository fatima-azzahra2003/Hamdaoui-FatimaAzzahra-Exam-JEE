package org.sid.examen.dtos;

import lombok.Data;
import java.util.Date;

@Data
public class CreditDTO {
    private Long id;
    private Date dateDemande;
    private String statut; // String ici car on veut exposer en texte simple
    private Date dateAcception;
    private double montant;
    private int dureeRemboursement;
    private double tauxInteret;
    private Long clientId;
}

