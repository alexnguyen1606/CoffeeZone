package com.CoffeeZone.dao.Impl;

import com.CoffeeZone.dao.IAccountDAO;
import com.CoffeeZone.entity.AccountEntity;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.sql.SQLException;
import java.util.ArrayList;
@Repository(value = "accountDAO")
@Transactional(rollbackFor = SQLException.class)
public class AccountDAO implements IAccountDAO {
    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("MSSQL");
    EntityManager entityManager = entityManagerFactory.createEntityManager();

    @Override
    public ArrayList<AccountEntity> findAll() {
        return (ArrayList<AccountEntity>) entityManager.createQuery("SELECT  a from AccountEntity a ");
    }

    @Override
    public AccountEntity findById(Integer id) {
        return entityManager.find(AccountEntity.class,id);
    }

    @Override
    public AccountEntity save(AccountEntity accountEntity) {
        entityManager.getTransaction().begin();
        entityManager.persist(accountEntity);
        entityManager.flush();
        entityManager.getTransaction().commit();
        return accountEntity;
    }

    @Override
    public AccountEntity update(AccountEntity accountEntity) {
        entityManager.getTransaction().begin();
        entityManager.merge(accountEntity);
        entityManager.flush();
        entityManager.getTransaction().commit();
        return accountEntity;
    }

    @Override
    public void deleteById(Integer id) {
        entityManager.getTransaction().begin();
        entityManager.remove(findById(id));
        entityManager.getTransaction().commit();
    }

    @Override
    public AccountEntity findByUsernameAndPasswordAndStatus(String username, String password) {
        ArrayList<AccountEntity> accounts= (ArrayList<AccountEntity>) entityManager.createQuery
                ("select a from AccountEntity a where a.username=:userName and a.password=:passWord and a.status=true ")
                .setParameter("userName",username).setParameter("passWord",password).getResultList();
        return accounts.size()!=0 ? accounts.get(0): null;
    }
    @Override
    public AccountEntity findByUsername(String username){
        ArrayList<AccountEntity> accounts = (ArrayList<AccountEntity>) entityManager.createQuery("select a from AccountEntity a where a.username=:Username")
                .setParameter("Username",username).getResultList();
        return accounts.size()>0?accounts.get(0) : null;
    }
}
