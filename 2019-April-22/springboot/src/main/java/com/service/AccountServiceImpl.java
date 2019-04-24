package com.service;

import com.model.Account;
import com.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AccountServiceImpl implements  AccountService {

    @Autowired
    private AccountRepository repository;

    @Override
    public List<Account> fetchAll() {
        return repository.fetchAll();
    }
    @Override
    public void save(Account account) throws Exception {
        repository.save(account);
    }

    @Override
    public void update(Account account) {
        repository.update(account);
    }

    @Override
    public void delete(Account account) {
        repository.delete(account);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = {Exception.class})
    public void transfer(int fromId, int toId, double amt) throws Exception {

        try{

            repository.deposit(toId, amt);
            repository.withdraw(fromId, amt);
        }catch (Exception ex){
            throw  ex;
        }
    }
}
