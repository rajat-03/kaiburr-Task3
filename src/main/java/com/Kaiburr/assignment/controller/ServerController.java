package com.Kaiburr.assignment.controller;

import com.Kaiburr.assignment.entity.Servers;
import com.Kaiburr.assignment.service.ServerService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins="*")
@RestController
public class ServerController {

    @Autowired
    private ServerService serverService;

    private final Logger LOGGER = LoggerFactory.getLogger(ServerController.class);

    @PutMapping("/putServer")
    public ResponseEntity<?> addServers(@Valid @RequestBody Servers servers){
        LOGGER.info("Adding a new Server");
        serverService.addServers(servers);
        return new ResponseEntity<String>("Server Inserted successfully!", HttpStatus.OK);
    }

    @PutMapping("/updateServers/{id}")
    public ResponseEntity<?> updateServer(@PathVariable("id") String id,@Valid @RequestBody Servers server){
        LOGGER.info("Updating Server");
        if(serverService.isPresent(id)){
            LOGGER.info("Found server with the specified ID");
            serverService.updateServer(id,server);
            return new ResponseEntity<String>("Server with id "+id+" Update Successfully",HttpStatus.OK);
        }
        LOGGER.info("Server Not found with the entered ID");
        return new ResponseEntity<String>("Server Not Found",HttpStatus.NOT_FOUND);
    }
    @GetMapping("/getServers")
    public List<Servers> fetchAllServers(){
        LOGGER.info("Fetching all Servers");
        return serverService.fetchAllServers();
    }

    @GetMapping("/getServers/{id}")
    public ResponseEntity<?> fetchServerById(@PathVariable("id") String id){
        LOGGER.info("Fetching server by ID");
        if(serverService.isPresent(id)){
            Servers server = serverService.fetchServerById(id);
            return new ResponseEntity<>(server,HttpStatus.OK);
        }
            return new ResponseEntity<String>("Server Not Found",HttpStatus.NOT_FOUND);
    }

    @GetMapping("/getServerByName/{name}")
    public ResponseEntity<?> fetchServersByName(@PathVariable("name") String name){
        LOGGER.info("Fetching Server with the Server name Provided");
        List<Servers> servers = serverService.fetchServerByName(name);
        return servers.isEmpty()?new ResponseEntity<String>("Server not found!", HttpStatus.NOT_FOUND):
                new ResponseEntity<List<Servers>>(servers, HttpStatus.OK);
    }
    @DeleteMapping("/deleteServer/{id}")
    public ResponseEntity<?> deleteServer(@PathVariable("id") String id){
        if(serverService.isPresent(id)){
            LOGGER.info("Found the Server to be deleted");
            serverService.deleteServer(id);
            return new ResponseEntity<String>("Server Deleted!", HttpStatus.OK);
        }
            LOGGER.info("Server not found with given ID");
            return new ResponseEntity<String>("Server not exists!", HttpStatus.OK);
    }
}