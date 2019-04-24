package com.beans;


import com.conditions.OnLinuxCondition;
import org.springframework.context.annotation.Conditional;
import org.springframework.stereotype.Service;

@Service
@Conditional(OnLinuxCondition.class)
public class AccountServiceMockImpl implements  AccountService{

    public String getName() {
        return "XYZ";
    }
}
