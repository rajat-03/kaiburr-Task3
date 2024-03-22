package com.Kaiburr.assignment.entity;


import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
@Data
@Document(collection = "Servers")
public class Servers {

    @Id
    private String id;
    @NotNull(message = "Add Name for the server")
    private String name;
    @NotNull(message = "Add language for the server")
    private String language;
    @NotNull(message = "Add framework for the server")
    private String framework;

}
