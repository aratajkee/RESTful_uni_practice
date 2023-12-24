package com.example.rest_playground.controller;

import com.example.rest_playground.model.Client;
import com.example.rest_playground.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin(origins = "*")
public class ClientController {

    private final ClientService clientService;

    @Autowired
    public ClientController(@Qualifier("clientServiceForDB") ClientService clientService) {
        this.clientService = clientService;
    }


    @RequestMapping(value = "/")
    public String home() {
        return "HEllow HEllowHEllowHEllowHEllow!@";
    }

     @PostMapping("/clients")
     public ResponseEntity<?> create(@RequestBody Client client) {
         clientService.create(client);
         return new ResponseEntity<>(HttpStatus.CREATED);
     }

//    @PostMapping("/clients")
//    public ResponseEntity<?> createMany(@RequestBody List <Client> clients) {
//        for (Client c : clients) {
//            clientService.create(c);
//        }
//        return clients != null && !clients.isEmpty()
//                ? new ResponseEntity<>(HttpStatus.CREATED)
//                : new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//    }

    @GetMapping("/clients")
    public ResponseEntity<List<Client>> read() {
        final List<Client> clients = clientService.readAll();

        return clients != null && !clients.isEmpty()
                ? new ResponseEntity<>(clients, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/clients/{id}")
    public ResponseEntity<Client> read(@PathVariable(name = "id") int id) {
        final Client client = clientService.read(id);
        return client != null
                ? new ResponseEntity<>(client, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/clients/{id}")
    public ResponseEntity<?> delete(@PathVariable(name = "id") int id) {
        final boolean isDeleted = clientService.delete(id);

        return isDeleted
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    @PutMapping("/clients/{id}")
    public ResponseEntity<?> update(@PathVariable(name = "id") int id, @RequestBody Client client) {
        final boolean isUpdated = clientService.update(client, id);

        return isUpdated
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

}
