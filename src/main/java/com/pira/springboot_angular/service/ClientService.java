package com.pira.springboot_angular.service;

import com.pira.springboot_angular.model.entity.Client;
import com.pira.springboot_angular.repository.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    public Client findById(Long id) {
        return clientRepository.findById(id)
                                .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Client not found."));
    }

    public List<Client> findAll() {
        return clientRepository.findAll();
    }

    public Client save(Client client) {
        return clientRepository.save(client);
    }

    public void delete(Long id) {
       clientRepository.delete(findById(id));
    }

    public void replace(Client client) {
        try {
            findById(client.getId());
        }finally {
            clientRepository.save(client);
        }
    }


}
