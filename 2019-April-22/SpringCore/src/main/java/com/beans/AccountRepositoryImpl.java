package com.beans;

import org.springframework.stereotype.Repository;

@Repository() // id=accountRepositoryImpl
public class AccountRepositoryImpl implements AccountRepository {

    public String getFirstName(){
        return "Anil";
    }

    public String getLastName(){
        return "Joseph";
    }

}
