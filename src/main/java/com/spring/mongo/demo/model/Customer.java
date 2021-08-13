package com.spring.mongo.demo.model;

import lombok.Builder;
import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document(collection = "customer")
public class Customer implements Serializable {

    @Id
    private String id;

    private String name;
    private String email;
    private String address;
    private int age;


    // Constructor, Getter and Setter
}