package com.lfsenior.springbootleaning.jpa;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/account")
public class AccountWeb {
    @Autowired
    private AccountDao accountDao;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public List<Account> list() {
        return accountDao.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Account findById(@PathVariable("id") int id) {
        return accountDao.findById(id).get();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public Account update(@PathVariable("id") int id, @RequestParam("name") String name) {
        Account account = new Account();
        account.setId(id);
        account.setName(name);
        return accountDao.saveAndFlush(account);
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public Account add(@RequestParam("name") String name, @RequestParam("pwd") String pwd) {
        Account account = new Account();
        account.setName(name);
        account.setPwd(pwd);
        return accountDao.save(account);
    }
}
