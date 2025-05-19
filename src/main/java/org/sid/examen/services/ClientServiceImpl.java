package org.sid.examen.services;

import org.sid.examen.dtos.ClientDTO;
import org.sid.examen.entities.Client;
import org.sid.examen.exceptions.ClientNotFoundException;
import org.sid.examen.mappers.ClientMapper;
import org.sid.examen.repositories.ClientRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClientServiceImpl implements ClientService {
    private final ClientRepository clientRepository;
    private final ClientMapper clientMapper;

    public ClientServiceImpl(ClientRepository clientRepository, ClientMapper clientMapper) {
        this.clientRepository = clientRepository;
        this.clientMapper = clientMapper;
    }

    @Override
    public ClientDTO saveClient(ClientDTO clientDTO) {
        Client client = clientMapper.fromDTO(clientDTO);
        Client saved = clientRepository.save(client);
        return clientMapper.toDTO(saved);
    }

    @Override
    public List<ClientDTO> listClients() {
        return clientRepository.findAll().stream().map(clientMapper::toDTO).collect(Collectors.toList());
    }

    @Override

    public ClientDTO getClient(Long id) {
        return clientRepository.findById(id).map(clientMapper::toDTO).orElse(null);
    }

    @Override
    public void deleteClient(Long id) {
        clientRepository.deleteById(id);
    }
}