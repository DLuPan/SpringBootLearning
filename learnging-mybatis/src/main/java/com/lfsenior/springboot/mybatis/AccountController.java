package com.lfsenior.springboot.mybatis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/account")
public class AccountController {
    @Autowired
    private AccountMapper accountMapper;

    @RequestMapping(value = "", method = RequestMethod.POST)
    public String add(@RequestParam("name") String name, @RequestParam("money") Double money) {
        if (accountMapper.add(name, money) > 0) {
            return "success";
        } else {
            return "fail";
        }
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public String delete(@PathVariable("id") Integer id) {
        if (accountMapper.delete(id) > 0) {
            return "success";
        } else {
            return "fail";
        }
    }


    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public String update(@PathVariable("id") Integer id, @RequestParam("name") String name, @RequestParam("money") Double money) {
        if (accountMapper.update(name, money, id) > 0) {
            return "sucess";
        } else {
            return "fail";
        }
    }


    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Account findById(@PathVariable("id") Integer id) {
        return accountMapper.findById(id);
    }


    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public List<Account> findAll() {
        return accountMapper.findAll();
    }

}
