package com.example.rest_playground.service;

import com.example.rest_playground.model.Client;
import com.example.rest_playground.repository.ClientRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientServiceForDB implements ClientService{

    private final ClientRepo clientRepo;

    public ClientServiceForDB(ClientRepo clientRepo) {
        this.clientRepo = clientRepo;
    }

    @Override
    public void create(Client client) {
        clientRepo.save(client);
    }

    @Override
    public List<Client> readAll() {
        return clientRepo.findAll();
    }

    @Override
    public Client read(int ID) {
        return clientRepo.findById(ID).isPresent()
                ? clientRepo.findById(ID).get()
                : null;
    }

    @Override
    public boolean update(Client client, int ID) {
        if (clientRepo.findById(ID).isPresent()) {
            clientRepo.delete(clientRepo.findById(ID).get());
            clientRepo.save(client);
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(int id) {
        clientRepo.delete(clientRepo.findById(id).get());
        return !clientRepo.findById(id).isPresent();
    }
}
