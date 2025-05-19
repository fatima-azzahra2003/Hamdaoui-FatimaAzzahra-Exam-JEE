package org.sid.examen.services;

import org.sid.examen.dtos.RemboursementDTO;

import java.util.List;

public interface RemboursementService {
    RemboursementDTO saveRemboursement(RemboursementDTO remboursementDTO);
    List<RemboursementDTO> listRemboursements();
    RemboursementDTO getRemboursement(Long id);
    void deleteRemboursement(Long id);
}
