package ru.netology.daolayerwithhibernate.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.netology.daolayerwithhibernate.model.Persons;

import java.util.List;

@Repository
public interface PersonRepository extends JpaRepository<Persons, Long> {
    List<Persons> findByCityOfLiving(String cityOfLiving);
}