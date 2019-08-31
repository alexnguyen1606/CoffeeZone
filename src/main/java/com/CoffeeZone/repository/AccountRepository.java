package com.CoffeeZone.repository;

import com.CoffeeZone.entity.AccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<AccountEntity,Integer>{

    public AccountEntity findOneByUsernameAndStatus(String name,Boolean status);
}
