package org.sid.jee_exam_backend.service;

import org.sid.jee_exam_backend.dtos.*;
import org.sid.jee_exam_backend.entities.*;
import org.sid.jee_exam_backend.dtos.CreditDTO;
import org.sid.jee_exam_backend.dtos.CreditImmobilierDTO;
import org.sid.jee_exam_backend.dtos.CreditPersonnelDTO;
import org.sid.jee_exam_backend.dtos.CreditProfessionnelDTO;
import org.sid.jee_exam_backend.entities.Credit;
import org.sid.jee_exam_backend.entities.CreditImmobilier;
import org.sid.jee_exam_backend.entities.CreditPersonnel;
import org.sid.jee_exam_backend.entities.CreditProfessionnel;
import org.sid.jee_exam_backend.mappers.CreditMapper;
import org.sid.jee_exam_backend.repositories.ClientRepository;
import org.sid.jee_exam_backend.repositories.CreditImmobilierRepository;
import org.sid.jee_exam_backend.repositories.CreditPersonnelRepository;
import org.sid.jee_exam_backend.repositories.CreditProfessionnelRepository;
import org.sid.jee_exam_backend.repositories.CreditRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CreditServiceImpl implements CreditService {
    private final CreditRepository creditRepository;
    private final CreditPersonnelRepository creditPersonnelRepository;
    private final CreditImmobilierRepository creditImmobilierRepository;
    private final CreditProfessionnelRepository creditProfessionnelRepository;
    private final ClientRepository clientRepository;
    private final CreditMapper creditMapper;

    public CreditServiceImpl(
            CreditRepository creditRepository,
            CreditPersonnelRepository creditPersonnelRepository,
            CreditImmobilierRepository creditImmobilierRepository,
            CreditProfessionnelRepository creditProfessionnelRepository,
            ClientRepository clientRepository,
            CreditMapper creditMapper
    ) {
        this.creditRepository = creditRepository;
        this.creditPersonnelRepository = creditPersonnelRepository;
        this.creditImmobilierRepository = creditImmobilierRepository;
        this.creditProfessionnelRepository = creditProfessionnelRepository;
        this.clientRepository = clientRepository;
        this.creditMapper = creditMapper;
    }

    @Override
    public CreditDTO saveCredit(CreditDTO creditDTO) {
        Credit credit;
        if (creditDTO instanceof CreditPersonnelDTO cpdto) {
            CreditPersonnel cp = CreditPersonnel.builder()
                    .id(cpdto.getId())
                    .dateDemande(cpdto.getDateDemande())
                    .statut(cpdto.getStatut())
                    .dateAcception(cpdto.getDateAcception())
                    .montant(cpdto.getMontant())
                    .dureeRemboursement(cpdto.getDureeRemboursement())
                    .tauxInteret(cpdto.getTauxInteret())
                    .motif(cpdto.getMotif())
                    .build();
            if (cpdto.getClientId() != null)
                cp.setClient(clientRepository.findById(cpdto.getClientId()).orElse(null));
            credit = creditPersonnelRepository.save(cp);
        } else if (creditDTO instanceof CreditImmobilierDTO cidto) {
            CreditImmobilier ci = CreditImmobilier.builder()
                    .id(cidto.getId())
                    .dateDemande(cidto.getDateDemande())
                    .statut(cidto.getStatut())
                    .dateAcception(cidto.getDateAcception())
                    .montant(cidto.getMontant())
                    .dureeRemboursement(cidto.getDureeRemboursement())
                    .tauxInteret(cidto.getTauxInteret())
                    .typeBien(cidto.getTypeBien())
                    .build();
            if (cidto.getClientId() != null)
                ci.setClient(clientRepository.findById(cidto.getClientId()).orElse(null));
            credit = creditImmobilierRepository.save(ci);
        } else if (creditDTO instanceof CreditProfessionnelDTO cproDto) {
            CreditProfessionnel cpro = CreditProfessionnel.builder()
                    .id(cproDto.getId())
                    .dateDemande(cproDto.getDateDemande())
                    .statut(cproDto.getStatut())
                    .dateAcception(cproDto.getDateAcception())
                    .montant(cproDto.getMontant())
                    .dureeRemboursement(cproDto.getDureeRemboursement())
                    .tauxInteret(cproDto.getTauxInteret())
                    .motif(cproDto.getMotif())
                    .raisonSociale(cproDto.getRaisonSociale())
                    .build();
            if (cproDto.getClientId() != null)
                cpro.setClient(clientRepository.findById(cproDto.getClientId()).orElse(null));
            credit = creditProfessionnelRepository.save(cpro);
        } else {
            throw new IllegalArgumentException("Type de crédit inconnu : " + creditDTO.getClass().getSimpleName());
        }
        return creditMapper.toDTO(credit);
    }

    @Override
    public List<CreditDTO> listCredits() {
        return creditRepository.findAll().stream().map(creditMapper::toDTO).collect(Collectors.toList());
    }

    @Override
    public CreditDTO getCredit(Long id) {
        return creditRepository.findById(id).map(creditMapper::toDTO).orElse(null);
    }

    @Override
    public void deleteCredit(Long id) {
        creditRepository.deleteById(id);
    }
}