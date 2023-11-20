package com.example.rest_playground.service;

import com.example.rest_playground.model.Client;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class ClientServiceImplementation implements ClientService {

    // Temp substitute for DB
    private static final Map<Integer, Client> CLIENTS_TEMP_REP_MAP = new HashMap<>();

    // Temp Client ID generator
    private static final AtomicInteger CLIENT_ID_HOLDER = new AtomicInteger();

    @Override
    public void create(Client client) {
        final int clientID = CLIENT_ID_HOLDER.incrementAndGet();
        client.setID(clientID);
        CLIENTS_TEMP_REP_MAP.put(clientID, client);
    }

    @Override
    public List<Client> readAll() {
        return new ArrayList<>(CLIENTS_TEMP_REP_MAP.values());
    }

    @Override
    public Client read(int ID) {
        return CLIENTS_TEMP_REP_MAP.get(ID);
    }

    @Override
    public boolean update(Client client, int ID) {
        if (CLIENTS_TEMP_REP_MAP.containsKey(ID)) {
            client.setID(ID);
            CLIENTS_TEMP_REP_MAP.put(ID,client);
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(int id) {
        return CLIENTS_TEMP_REP_MAP.remove(id) != null;
    }
}
