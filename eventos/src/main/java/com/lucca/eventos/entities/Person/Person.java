package com.lucca.eventos.entities.Person;

import com.lucca.eventos.service.GenerateIds;
import lombok.Getter;
import lombok.Setter;

@Getter
public abstract class Person {

    @Setter
    private String name;
    @Setter
    private String cpf;
    @Setter
    private String email;
    @Setter
    private String password;
    private final int id;
    @Setter
    private int age;

    public Person(String name, String cpf, String email, String password, int age) {
        this.name = name;
        this.cpf = cpf;
        this.email = email;
        this.password = password;
        this.age = age;
        this.id = GenerateIds.generatePersonId();
    }

    public Person() {
        this.id = GenerateIds.generatePersonId();
    }
}
