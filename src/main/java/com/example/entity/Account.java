package com.example.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created with Account
 * User: pual
 * Date: 2016/10/12
 * Desc:
 */
@Entity(name = "account")
@Data
public class Account {
    @Id
    @GeneratedValue
    private long id;
    private String accountName;
    @JsonIgnore
    private String password;
    @Column(nullable = false, unique = true)
    private String username;
}
