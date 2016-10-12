package com.example.service;

import com.example.entity.Account;
import com.example.jpa.AccountRepository;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created with UserDetailService
 * User: pual
 * Date: 2016/10/12
 * Desc:
 */
@Service
public class AccountService {
    private static final Logger logger = Logger.getLogger(AccountService.class);
    @Autowired
    private AccountRepository accountRepository;

    public Account getAccountByUserName(String name){
        return accountRepository.findByAccountName(name);
    }

    public Account getAccountById(long id) {
        return accountRepository.findOne(id);
    }
}
