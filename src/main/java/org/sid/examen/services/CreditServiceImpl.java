package org.sid.examen.services;

import lombok.RequiredArgsConstructor;
import org.sid.examen.dtos.CreditDTO;
import org.sid.examen.entities.Client;
import org.sid.examen.entities.Credit;
import org.sid.examen.exceptions.ClientNotFoundException;
import org.sid.examen.exceptions.CreditNotFoundException;
import org.sid.examen.mappers.CreditMapper;
import org.sid.examen.repositories.ClientRepository;
import org.sid.examen.repositories.CreditRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CreditServiceImpl implements CreditService {

    private final CreditRepository creditRepository;
    private final CreditMapper creditMapper;
    private final ClientRepository clientRepository;

    @Override
    public CreditDTO saveCredit(CreditDTO creditDTO) {
        Client client = clientRepository.findById(creditDTO.getClientId())
                .orElseThrow(() -> new ClientNotFoundException("Client not found"));

        Credit credit = creditMapper.toEntity(creditDTO);
        credit.setClient(client);
        Credit savedCredit = creditRepository.save(credit);
        return creditMapper.toDTO(savedCredit);
    }

    @Override
    public CreditDTO getCredit(Long id) {
        Credit credit = creditRepository.findById(id)
                .orElseThrow(() -> new CreditNotFoundException("Credit not found with ID: " + id));
        return creditMapper.toDTO(credit);
    }

    @Override
    public List<CreditDTO> listCredits() {
        return creditRepository.findAll().stream()
                .map(creditMapper::toDTO)
                .collect(Collectors.toList());
    }


    @Override
    public CreditDTO updateCredit(Long id, CreditDTO creditDTO) {
        Credit credit = creditRepository.findById(id)
                .orElseThrow(() -> new CreditNotFoundException("Credit not found"));

        credit.setMontant(creditDTO.getMontant());
        credit.setDateAcception(creditDTO.getDateAcception());
        if (creditDTO.getStatut() != null) {
            credit.setStatut(org.sid.examen.enums.StatutCredit.valueOf(creditDTO.getStatut()));
        }

        Client client = clientRepository.findById(creditDTO.getClientId())
                .orElseThrow(() -> new ClientNotFoundException("Client not found"));
        credit.setClient(client);

        Credit updatedCredit = creditRepository.save(credit);
        return creditMapper.toDTO(updatedCredit);
    }

    @Override
    public void deleteCredit(Long id) {
        Credit credit = creditRepository.findById(id)
                .orElseThrow(() -> new CreditNotFoundException("Credit not found"));
        creditRepository.delete(credit);
    }
}
