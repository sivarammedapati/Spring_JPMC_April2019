package com.beans;

import org.springframework.stereotype.Repository;

@Repository
public class AccountRepositoryMockImpl implements  AccountRepository {

    public String getFirstName() {
        return "Sachin";
    }

    public String getLastName() {
        return "Tendulkar";
    }
}
