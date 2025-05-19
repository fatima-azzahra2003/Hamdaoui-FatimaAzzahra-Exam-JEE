package org.sid.jee_exam_backend.service;

import org.sid.jee_exam_backend.dtos.RemboursementDTO;
import org.sid.jee_exam_backend.entities.Credit;
import org.sid.jee_exam_backend.entities.Remboursement;
import org.sid.jee_exam_backend.mappers.RemboursementMapper;
import org.sid.jee_exam_backend.repositories.CreditRepository;
import org.sid.jee_exam_backend.repositories.RemboursementRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RemboursementServiceImpl implements RemboursementService {

    private final RemboursementRepository remboursementRepository;
    private final CreditRepository creditRepository;
    private final RemboursementMapper remboursementMapper;

    public RemboursementServiceImpl(
            RemboursementRepository remboursementRepository,
            CreditRepository creditRepository,
            RemboursementMapper remboursementMapper
    ) {
        this.remboursementRepository = remboursementRepository;
        this.creditRepository = creditRepository;
        this.remboursementMapper = remboursementMapper;
    }

    @Override
    public RemboursementDTO saveRemboursement(RemboursementDTO remboursementDTO) {
        Remboursement remboursement = remboursementMapper.fromDTO(remboursementDTO);
        if (remboursementDTO.getCreditId() != null) {
            Credit credit = creditRepository.findById(remboursementDTO.getCreditId()).orElse(null);
            remboursement.setCredit(credit);
        }
        Remboursement saved = remboursementRepository.save(remboursement);
        return remboursementMapper.toDTO(saved);
    }

    @Override
    public List<RemboursementDTO> listRemboursements() {
        return remboursementRepository.findAll().stream()
                .map(remboursementMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public RemboursementDTO getRemboursement(Long id) {
        return remboursementRepository.findById(id)
                .map(remboursementMapper::toDTO)
                .orElse(null);
    }

    @Override
    public void deleteRemboursement(Long id) {
        remboursementRepository.deleteById(id);
    }
}
