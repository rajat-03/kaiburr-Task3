package com.assignment.kaiburr.repository;

import com.assignment.kaiburr.model.Server;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ServerRepository extends MongoRepository<Server,String> {
    Server findServerById(String id);
    void deleteServerById(String id);
    List<Server> findByNameContaining(String name);
}
