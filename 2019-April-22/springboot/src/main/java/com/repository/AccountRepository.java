package com.repository;

import com.model.Account;

import java.util.List;

public interface AccountRepository {
    List<Account> fetchAll();

    void save(Account account) throws Exception;

    void update(Account account);

    void delete(Account account);

    void deposit(int id, double amt)throws  Exception;

    void withdraw(int id, double amt)throws  Exception;
}
