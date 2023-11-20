package com.example.rest_playground.utils;

import com.example.rest_playground.model.Client;
import com.example.rest_playground.service.ClientServiceForDB;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InitiateUtils implements CommandLineRunner {

    private final ClientServiceForDB clientService;

    public InitiateUtils(ClientServiceForDB clientService) {
        this.clientService = clientService;
    }
    @Override
    public void run(String... args) throws Exception {

//        Client client1 = new Client();
//        client1.setName("Kenny");
//        client1.setEmail("Pidors@gmal.russia");
//        client1.setP_number(880055535);
//
//        Client client2 = new Client();
//        client2.setName("DEBIL");
//        client2.setEmail("typayatvar@pidor.ru");
//        client2.setP_number(1234567);
//
//        Client client3 = new Client();
//        client3.setName("MaximKac");
//        client3.setEmail("predlogal@sdatca.israel");
//        client3.setP_number(100500);
//
//        clientService.create(client1);
//        clientService.create(client2);
//        clientService.create(client3);
//
//        List<Client> all = clientService.readAll();
//        for (Client c: all) {
//            System.out.println(c.toString());
//        }
//        System.out.printf("\n====================================\n");
//        System.out.printf(clientService.read(1).toString());
//
//        clientService.delete(1);
//        System.out.printf("\n====================================\n");
//        all = clientService.readAll();
//        for (Client c: all) {
//            System.out.println(c.toString());
//        }


    }
}
