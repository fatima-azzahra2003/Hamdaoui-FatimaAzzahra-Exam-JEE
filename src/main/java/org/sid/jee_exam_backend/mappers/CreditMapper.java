package org.sid.jee_exam_backend.mappers;

import org.sid.jee_exam_backend.dtos.CreditDTO;
import org.sid.jee_exam_backend.dtos.CreditImmobilierDTO;
import org.sid.jee_exam_backend.dtos.CreditPersonnelDTO;
import org.sid.jee_exam_backend.dtos.CreditProfessionnelDTO;
import org.sid.jee_exam_backend.entities.Credit;
import org.sid.jee_exam_backend.entities.CreditImmobilier;
import org.sid.jee_exam_backend.entities.CreditPersonnel;
import org.sid.jee_exam_backend.entities.CreditProfessionnel;
import org.springframework.stereotype.Service;

@Service
public class CreditMapper {
    public CreditDTO toDTO(Credit credit) {
        if (credit == null) return null;
        if (credit instanceof CreditPersonnel) {
            CreditPersonnelDTO dto = new CreditPersonnelDTO();
            fillBaseFields(dto, credit);
            dto.setMotif(((CreditPersonnel) credit).getMotif());
            return dto;
        } else if (credit instanceof CreditImmobilier) {
            CreditImmobilierDTO dto = new CreditImmobilierDTO();
            fillBaseFields(dto, credit);
            dto.setTypeBien(((CreditImmobilier) credit).getTypeBien());
            return dto;
        } else if (credit instanceof CreditProfessionnel) {
            CreditProfessionnelDTO dto = new CreditProfessionnelDTO();
            fillBaseFields(dto, credit);
            dto.setMotif(((CreditProfessionnel) credit).getMotif());
            dto.setRaisonSociale(((CreditProfessionnel) credit).getRaisonSociale());
            return dto;
        } else {
            CreditDTO dto = new CreditDTO();
            fillBaseFields(dto, credit);
            return dto;
        }
    }

    private void fillBaseFields(CreditDTO dto, Credit credit) {
        dto.setId(credit.getId());
        dto.setDateDemande(credit.getDateDemande());
        dto.setStatut(credit.getStatut());
        dto.setDateAcception(credit.getDateAcception());
        dto.setMontant(credit.getMontant());
        dto.setDureeRemboursement(credit.getDureeRemboursement());
        dto.setTauxInteret(credit.getTauxInteret());
        if (credit.getClient() != null) dto.setClientId(credit.getClient().getId());
    }
}
