package com.example.accountdubboservice.controller;

import com.example.accountdubboservice.pojo.User;
import com.example.accountdubboservice.service.BalanceService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
@RestController
public class AccountController {
    @Autowired
    private BalanceService balanceService;
    final static
    Map<Integer, User> userMap = new HashMap() {{
        put(1, new User(1, "张三"));
        put(2, new User(2, "李四"));
        put(3, new User(3, "王五"));
    }
    };

    @RequestMapping("/acc/user")
    public User getUser(@RequestParam Integer id) {
        if(id != null && userMap.containsKey(id)) {
            User user = userMap.get(id);
             return user;
        }
        return new User(0, "");
    }
}
