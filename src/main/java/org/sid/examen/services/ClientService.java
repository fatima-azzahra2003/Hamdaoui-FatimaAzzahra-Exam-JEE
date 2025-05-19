package org.sid.examen.services;

import org.sid.examen.dtos.ClientDTO;

import java.util.List;

public interface ClientService {
    ClientDTO saveClient(ClientDTO clientDTO);
    List<ClientDTO> listClients();
    ClientDTO getClient(Long id);
    void deleteClient(Long id);
}
