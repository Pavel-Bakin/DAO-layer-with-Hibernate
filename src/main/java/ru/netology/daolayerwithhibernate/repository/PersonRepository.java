package ru.netology.daolayerwithhibernate.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import ru.netology.daolayerwithhibernate.model.Person;
import java.util.List;

@Repository
@Transactional
public class PersonRepository {
    @PersistenceContext
    private EntityManager entityManager;

    public List<Person> findByCityOfLiving(String cityOfLiving) {
        try {
            return entityManager.createQuery("SELECT p FROM Person p WHERE p.cityOfLiving = :city", Person.class)
                    .setParameter("city", cityOfLiving)
                    .getResultList();
        } catch (NoResultException | NonUniqueResultException e) {
            return null;
        }
    }
}