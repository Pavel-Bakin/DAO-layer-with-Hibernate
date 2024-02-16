package ru.netology.daolayerwithhibernate.model;


import javax.persistence.*;


import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
@Entity
@Table(name = "persons")
@IdClass(PersonId.class)
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Id
    private String name;
    @Id
    private String surname;
    private int age;
    @Column(name = "phone_number")
    private String phoneNumber;
    @Column(name = "city_of_living")
    private String cityOfLiving;

}
