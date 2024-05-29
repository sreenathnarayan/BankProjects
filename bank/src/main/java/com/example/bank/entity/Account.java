package com.example.bank.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity

public class Account {
    @Id
    @GeneratedValue
    private Long id;
    private String accountHolderName;
    private double balance;
}
