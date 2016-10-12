package com.example.controller;

import com.example.entity.Account;
import com.example.service.AccountService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
}
