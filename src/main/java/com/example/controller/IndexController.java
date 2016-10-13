package com.example.controller;

import com.example.entity.Account;
import com.example.service.AccountService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * Created with IndexController
 * User: pual
 * Date: 2016/10/12
 * Desc:
 */
@RestController
public class IndexController {
    private static final Logger logger = Logger.getLogger(IndexController.class);

    @Autowired private AccountService accountService;

    @RequestMapping(value = "/index/{id}",method = RequestMethod.GET)
    public ResponseEntity<?> index(@PathVariable("id")long id){
        Account account = accountService.getAccountById(id);
        return new ResponseEntity<>(account, HttpStatus.OK);
    }

    @RequestMapping(value = "/newaccount",method = RequestMethod.POST)
    public ResponseEntity<?> newaccount(@RequestBody @Valid Account account, BindingResult result){
        if(result.hasErrors()){
            return new ResponseEntity<> (result.getAllErrors(), HttpStatus.BAD_REQUEST);
        }
        account = accountService.newAccount(account);
        return new ResponseEntity<>(account,HttpStatus.CREATED);
    }

    @RequestMapping(value = "/delete/{id}",method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteId(@PathVariable("id")long id){
        accountService.deleteAccount(id);
        return new ResponseEntity<>(true,HttpStatus.NO_CONTENT);
    }

    @RequestMapping(value = "/updateAccount/{id}",method = RequestMethod.PUT)
    public ResponseEntity<?> updateAccount(@RequestBody @Valid Account account, BindingResult result){
        if(result.hasErrors()){
            return new ResponseEntity<> (result.getAllErrors(), HttpStatus.BAD_REQUEST);
        }
        account = accountService.updateAccount(account);
        return new ResponseEntity<>(account,HttpStatus.CREATED);
    }
}
