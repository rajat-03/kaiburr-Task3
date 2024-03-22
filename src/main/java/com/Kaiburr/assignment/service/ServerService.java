package com.Kaiburr.assignment.service;

import com.Kaiburr.assignment.entity.Servers;

import java.util.List;


public interface ServerService {

    void addServers(Servers servers);

    List<Servers> fetchAllServers();

    List<Servers> fetchServerByName(String name);

    boolean isPresent(String id);

    void deleteServer(String id);

    void updateServer(String id, Servers server);

    Servers fetchServerById(String id);
}
