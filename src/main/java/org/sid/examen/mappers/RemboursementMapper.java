package org.sid.examen.mappers;

import org.sid.examen.dtos.RemboursementDTO;
import org.sid.examen.entities.Remboursement;
import org.sid.examen.enums.TypeRemboursement;
import org.springframework.stereotype.Service;

@Service
public class RemboursementMapper {

    public RemboursementDTO toDTO(Remboursement remboursement) {
        if (remboursement == null) return null;
        RemboursementDTO dto = new RemboursementDTO();
        dto.setId(remboursement.getId());
        dto.setDate(remboursement.getDate());
        dto.setMontant(remboursement.getMontant());
        dto.setType(remboursement.getType().name());
        if (remboursement.getCredit() != null) {
            dto.setCreditId(remboursement.getCredit().getId());
        }
        return dto;
    }


    public Remboursement fromDTO(RemboursementDTO dto) {
        if (dto == null) return null;
        Remboursement remboursement = new Remboursement();
        remboursement.setId(dto.getId());
        remboursement.setDate(dto.getDate());
        remboursement.setMontant(dto.getMontant());
        if (dto.getType() != null) {
            remboursement.setType(TypeRemboursement.valueOf(dto.getType()));
        }
        // Le lien avec Credit doit être injecté via le service
        return remboursement;
    }
}
