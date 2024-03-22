package com.assignment.kaiburr.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "server")
public class Server {
    String name;
    @Id
    String id;
    String language;
    String framework;

    public Server(String name, String id, String language, String framework) {
        this.name = name;
        this.id = id;
        this.language = language;
        this.framework = framework;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getFramework() {
        return framework;
    }

    public void setFramework(String framework) {
        this.framework = framework;
    }
}
