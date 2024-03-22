package com.Kaiburr.assignment.repository;

import com.Kaiburr.assignment.entity.Servers;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ServersRepository extends MongoRepository<Servers,Integer> {
    List<Servers> findByNameContaining(String name);
    List<Servers> findById(String id);
    void deleteById(String id);
}
