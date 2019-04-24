package com.controller;

import com.model.Account;
import com.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/accounts")
public class AccountController {

    @Autowired
    private AccountService service;


    @RequestMapping("/list")
    public String list(Model model){

        List<Account> accounts = service.fetchAll();
        model.addAttribute("accounts", accounts);
        return "listAccounts";

    }

    @RequestMapping("/transfer/{fId}/{tId}/{amt}")
    @ResponseBody
    public String transfer(
            @PathVariable("fId") int fromId,
            @PathVariable("tId") int toId,
            @PathVariable("amt") double amt){

        try{

            service.transfer(fromId, toId, amt);
            return "Transfer Complete";
        }
        catch (Exception ex){
            return "Transfer Failed";
        }
    }

}








