package org.sid.jee_exam_backend.mappers;

import org.sid.jee_exam_backend.dtos.ClientDTO;
import org.sid.jee_exam_backend.entities.Client;
import org.springframework.stereotype.Service;

@Service
public class ClientMapper {
    public ClientDTO toDTO(Client client) {
        if (client == null) return null;
        ClientDTO dto = new ClientDTO();
        dto.setId(client.getId());
        dto.setNom(client.getNom());
        dto.setEmail(client.getEmail());
        return dto;
    }

    public Client fromDTO(ClientDTO dto) {
        if (dto == null) return null;
        Client client = new Client();
        client.setId(dto.getId());
        client.setNom(dto.getNom());
        client.setEmail(dto.getEmail());
        return client;
    }
}