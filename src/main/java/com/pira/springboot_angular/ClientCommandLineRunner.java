package com.pira.springboot_angular;

import com.pira.springboot_angular.model.entity.Client;
import com.pira.springboot_angular.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class ClientCommandLineRunner {

    @Bean
    public CommandLineRunner run(@Autowired ClientRepository clientRepository){
        return args -> {
            //Client client = Client.builder().name("Cliente Test Runner").nif("000000000").build();
            //clientRepository.save(client);
        };
    }
}
