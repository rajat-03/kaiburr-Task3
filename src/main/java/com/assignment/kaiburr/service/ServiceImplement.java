package com.assignment.kaiburr.service;

import com.assignment.kaiburr.model.Server;
import com.assignment.kaiburr.repository.ServerRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class ServiceImplement implements Services{
    @Autowired
    private ServerRepository serverRepository;

    @Override
    public void putServer(Server server) {
        serverRepository.save(server);
    }
}
