package com.example.workflow;

import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class ClientService {

    private final Set<String> clients = new HashSet<>();

    public boolean isExist(String name) {
        return clients.contains(name);
    }

    public void add(String name) {
        clients.add(name);
    }
}
