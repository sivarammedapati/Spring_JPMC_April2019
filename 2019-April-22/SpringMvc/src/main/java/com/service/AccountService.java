package com.service;

import com.model.Account;

import java.util.List;

public interface AccountService {

    List<Account> fetchAll();

    void save(Account account) throws Exception;

    void update(Account account);

    void delete(Account account);

    void transfer(int fromId, int toId, double amt)throws  Exception;

}
