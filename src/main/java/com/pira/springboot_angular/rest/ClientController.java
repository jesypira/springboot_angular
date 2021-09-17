package com.pira.springboot_angular.rest;

import com.pira.springboot_angular.model.entity.Client;
import com.pira.springboot_angular.service.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequestMapping("/api/client")
@RestController
@RequiredArgsConstructor
public class ClientController {

    @Autowired
    private ClientService clientService;

    @GetMapping("/{id}")
    public Client findById(@PathVariable Long id){
        return clientService.findById(id);
    }

    @GetMapping
    public List<Client> findAll(){
        return clientService.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Client save(@RequestBody @Valid  Client client){
        return clientService.save(client);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id){
        clientService.delete(id);
    }

    @PutMapping("/{id}")
    public void replace(@PathVariable Long id, @RequestBody @Valid Client client){
        client.setId(id);
        clientService.replace(client);
    }

}
