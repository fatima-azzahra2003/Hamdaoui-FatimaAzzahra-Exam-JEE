package org.sid.examen.services;

import org.sid.examen.dtos.CreditDTO;

import java.util.List;

public interface CreditService {
    CreditDTO saveCredit(CreditDTO creditDTO);
    List<CreditDTO> listCredits();
    CreditDTO getCredit(Long id);
    void deleteCredit(Long id);

    // Ajout de la méthode updateCredit
    CreditDTO updateCredit(Long id, CreditDTO creditDTO);
}

