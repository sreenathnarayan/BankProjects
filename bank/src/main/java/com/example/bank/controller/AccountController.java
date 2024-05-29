package com.example.bank.controller;

import com.example.bank.entity.Account;
import com.example.bank.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.security.auth.login.AccountNotFoundException;
import java.util.Map;
import java.util.logging.Logger;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {

    Logger logger = Logger.getLogger(AccountController.class.getName());

    @Autowired
    private AccountService accountService;

    @PostMapping
    public Account createAccount(@RequestBody Account account) {
        return accountService.createAccount(account);
    }

    @GetMapping("/{id}")
    public Account getAccountById(@PathVariable Long id) throws AccountNotFoundException {
        return accountService.getAccount(id).orElseThrow(() -> new AccountNotFoundException("Account not found"));
    }

    @PostMapping("/{id}/deposit")
    public Account deposit(@PathVariable Long id, @RequestBody Map<String,Double> request) {
        Double amount = request.get("amount");
        logger.info("Account deposit: " + id);
        return accountService.deposit(id, amount);
    }

    @PostMapping("/{id}/withdraw")
    public Account withdraw(@PathVariable Long id, @RequestBody Map<String,Double> request) {
        Double amount = request.get("amount");
        logger.info("Account withdrawn: " + id);
        return accountService.withdraw(id, amount);

    }

}
