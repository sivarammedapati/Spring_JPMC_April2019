package com.beans;

import com.conditions.OnWindowsCondition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Conditional;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Service
@Conditional(OnWindowsCondition.class)
public class AccountServiceImpl implements AccountService {


    public AccountServiceImpl(){

        System.out.println("AccountServiceImpl.AccountServiceImpl: " + accountRepository);
    }

    @PostConstruct
    public void init(){
        System.out.println("AccountServiceImpl.init: " + accountRepository);

    }
    @PreDestroy
    public void destroy(){
        System.out.println("AccountServiceImpl.destroy: ");
    }

    @Autowired
    @Qualifier("accountRepositoryMockImpl")
    private AccountRepository accountRepository;


    public String getName(){
        return accountRepository.getFirstName() + " " +accountRepository.getLastName();
    }
}
