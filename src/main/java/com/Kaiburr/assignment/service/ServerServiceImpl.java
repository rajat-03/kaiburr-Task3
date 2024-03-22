package com.Kaiburr.assignment.service;

import com.Kaiburr.assignment.entity.Servers;
import com.Kaiburr.assignment.repository.ServersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class ServerServiceImpl implements ServerService{
    @Autowired
    private ServersRepository serversRepository;
    @Override
    public void addServers(Servers servers){
        serversRepository.save(servers);
    }
    @Override
    public List<Servers> fetchAllServers(){
        return serversRepository.findAll();
    }

    @Override
    public List<Servers> fetchServerByName(String name) {
        return serversRepository.findByNameContaining(name);
    }

    @Override
    public boolean isPresent(String id) {
       return !serversRepository.findById(id).isEmpty();
    }

    @Override
    public void deleteServer(String id) {
        serversRepository.deleteById(id);
    }

    @Override
    public void updateServer(String id, Servers server) {
        Servers foundServer = serversRepository.findById(id).get(0);
        if(Objects.nonNull(server.getName())&&!"".equalsIgnoreCase(server.getName())){
            foundServer.setName(server.getName());
        }
        if(Objects.nonNull(server.getLanguage())&&!"".equalsIgnoreCase(server.getLanguage())){
            foundServer.setLanguage(server.getLanguage());
        }
        if(Objects.nonNull(server.getFramework())&&!"".equalsIgnoreCase(server.getFramework())){
            foundServer.setFramework(server.getFramework());
        }
        serversRepository.save(foundServer);
    }

    @Override
    public Servers fetchServerById(String id) {
        return serversRepository.findById(id).get(0);
    }

}
