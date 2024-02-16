package ru.netology.daolayerwithhibernate.model;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Setter
@Getter
public class PersonId implements Serializable {
    private Long id;
    private int age;
    private String name;
    private String surname;
}
