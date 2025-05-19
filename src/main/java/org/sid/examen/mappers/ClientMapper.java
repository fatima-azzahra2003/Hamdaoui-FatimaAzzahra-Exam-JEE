package org.sid.examen.mappers;

import org.sid.examen.dtos.ClientDTO;
import org.sid.examen.entities.Client;
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