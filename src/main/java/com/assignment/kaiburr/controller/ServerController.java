package com.assignment.kaiburr.controller;

import com.assignment.kaiburr.model.Server;
import com.assignment.kaiburr.repository.ServerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
public class ServerController {
    @Autowired
    private ServerRepository serverRepository;

    @GetMapping("/")
    public String Welcome() {
        return "Welcome to Kaiburr Assignment";
    }

    @PutMapping("/insertServer")
    public String addServer(@RequestBody Server server) {
        serverRepository.save(server);
        return "Server Created";
    }

    @GetMapping("/getServers")
    public List<Server> getAllServer() {
        return serverRepository.findAll();
    }

    @GetMapping("/getServers/{id}")
    public ResponseEntity<?> getServer(@PathVariable("id") String id) {

        Server server = serverRepository.findServerById(id);
        if (server == null) {
            return new ResponseEntity<>("404, Server not found", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(server, HttpStatus.OK);
    }

    @GetMapping("/findByName/{name}")
    public ResponseEntity<?> findServersByName(@PathVariable("name") String name) {
        List<Server> servers = serverRepository.findByNameContaining(name);
        if (servers.isEmpty()) {
            return new ResponseEntity<>("404, Server not found", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(servers, HttpStatus.OK);
    }

    @DeleteMapping("/deleteServer/{id}")
    public String deleteServer(@PathVariable("id") String id) {
        if (serverRepository.findServerById(id) == null) {
            return "404, Server not found";
        }
        serverRepository.deleteServerById(id);
        return "Server Deleted";
    }

}