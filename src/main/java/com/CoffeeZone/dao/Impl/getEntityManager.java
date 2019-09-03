package com.CoffeeZone.dao.Impl;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.EntityManagerFactory;

public class getEntityManager {

    public static EntityManager entityManager(){
        EntityManagerFactory entityManagerFactory = (EntityManagerFactory) Persistence.createEntityManagerFactory("MSSQL");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        return entityManager;
    }
}
