package com.controller;

import com.model.Account;
import com.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/rest/accounts")
public class AccountRESTController {

    @Autowired
    private AccountService service;

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Account> fetchAll(){

        return service.fetchAll();
    }

    @RequestMapping(value="/{id}", method = RequestMethod.GET, produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    //public Account fetchById(@PathVariable int id){
    public ResponseEntity<Account> fetchById(@PathVariable int id){

        List<Account> accounts = service.fetchAll();
        Optional<Account> optionalAccount = accounts.stream().filter(acc -> acc.getId() == id).findFirst();

        if(optionalAccount.isPresent()){
            return ResponseEntity.ok(optionalAccount.get());
        }
        else{
            return ResponseEntity.notFound().build();
        }
    }

    @RequestMapping(method = RequestMethod.POST,
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity createAccount(@RequestBody Account account){

        try {

            service.save(account);
            return ResponseEntity.created( new URI("/accounts/" + account.getId()) ).build();

        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();

        }
    }

}










