package org.sid.examen.mappers;

import org.sid.examen.dtos.*;
import org.sid.examen.entities.*;
import org.springframework.stereotype.Service;

@Service
public class CreditMapper {

    public CreditDTO toDTO(Credit credit) {
        if (credit == null) return null;

        if (credit instanceof CreditPersonnel cp) {
            CreditPersonnelDTO dto = new CreditPersonnelDTO();
            fillBaseFields(dto, credit);
            dto.setMotif(cp.getMotif());
            dto.setStatut(credit.getStatut().name());
            return dto;
        }

        else if (credit instanceof CreditImmobilier ci) {
            CreditImmobilierDTO dto = new CreditImmobilierDTO();
            fillBaseFields(dto, credit);
            dto.setTypeBien(ci.getTypeBien().name());
            dto.setStatut(credit.getStatut().name());
            return dto;
        }

        else if (credit instanceof CreditProfessionnel cpro) {
            CreditProfessionnelDTO dto = new CreditProfessionnelDTO();
            fillBaseFields(dto, credit);
            dto.setMotif(cpro.getMotif());
            dto.setRaisonSociale(cpro.getRaisonSociale());
            dto.setStatut(credit.getStatut().name());
            return dto;
        }

        else {
            CreditDTO dto = new CreditDTO();
            fillBaseFields(dto, credit);
            dto.setStatut(credit.getStatut().name());
            return dto;
        }
    }

    private void fillBaseFields(CreditDTO dto, Credit credit) {
        dto.setId(credit.getId());
        dto.setDateDemande(credit.getDateDemande());
        dto.setDateAcception(credit.getDateAcception());
        dto.setMontant(credit.getMontant());
        dto.setDureeRemboursement(credit.getDureeRemboursement());
        dto.setTauxInteret(credit.getTauxInteret());
        if (credit.getClient() != null) {
            dto.setClientId(credit.getClient().getId());
        }
    }

    // Méthode pour convertir un DTO en entité (utile pour save/update)
    public Credit toEntity(CreditDTO dto) {
        if (dto == null) return null;

        Credit credit;
        if (dto instanceof CreditPersonnelDTO cpDTO) {
            CreditPersonnel cp = new CreditPersonnel();
            cp.setMotif(cpDTO.getMotif());
            credit = cp;
        } else if (dto instanceof CreditImmobilierDTO ciDTO) {
            CreditImmobilier ci = new CreditImmobilier();
            ci.setTypeBien(org.sid.examen.enums.TypeImmobilier.valueOf(ciDTO.getTypeBien()));
            credit = ci;
        } else if (dto instanceof CreditProfessionnelDTO cproDTO) {
            CreditProfessionnel cpro = new CreditProfessionnel();
            cpro.setMotif(cproDTO.getMotif());
            cpro.setRaisonSociale(cproDTO.getRaisonSociale());
            credit = cpro;
        } else {
            credit = new Credit() {}; // classe abstraite donc on crée une anonyme (à adapter)
        }

        credit.setId(dto.getId());
        credit.setDateDemande(dto.getDateDemande());
        credit.setDateAcception(dto.getDateAcception());
        credit.setMontant(dto.getMontant());
        credit.setDureeRemboursement(dto.getDureeRemboursement());
        credit.setTauxInteret(dto.getTauxInteret());
        if (dto.getStatut() != null) {
            credit.setStatut(org.sid.examen.enums.StatutCredit.valueOf(dto.getStatut()));
        }

        return credit;
    }
}
