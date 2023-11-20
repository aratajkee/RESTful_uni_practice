package com.example.rest_playground.service;

import com.example.rest_playground.model.Client;

import java.util.List;

public interface ClientService {
    void create(Client client);

    List<Client> readAll();

    Client read(int ID);

    boolean update(Client client, int ID);

    boolean delete(int id);
}
