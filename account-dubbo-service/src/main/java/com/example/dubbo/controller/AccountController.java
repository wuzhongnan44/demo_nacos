package com.example.dubbo.controller;

import com.example.dubbo.pojo.User;
import com.example.dubbo.pojo.UserJson;
import com.example.dubbo.service.BalanceService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
public class AccountController {

    final static Map<Integer, User> userMap = new HashMap() {
        {
            put(1, new User(1, "张三"));
            put(2, new User(2, "李四"));
            put(3, new User(3, "王五"));
        }
    };

    @Reference
    private BalanceService balanceService;

    @RequestMapping("/acc/user")
    public UserJson getUser(@RequestBody User user) {
        int id = Integer.valueOf(user.getId());
        if (userMap.containsKey(id)) {
            User user2 = userMap.get(id);
            user2.setBalance(balanceService.getBalance(id));
            User user1 = userMap.get(2);

            List<User> users = Arrays.asList(new User[]{user2, user1});
            return new UserJson("0",users);
        }
        User[] users=new User[]{new User(0,"")};
        List<User> users1 = Arrays.asList(users);
        return new UserJson("0",users1);

    }
    @RequestMapping("/acc/user1")
    public List<User> getUserByMap(@RequestBody HashMap map) {
        Integer id = (Integer) map.get("id");
        if (id != null && userMap.containsKey(id)) {
            User user = userMap.get(id);
            user.setBalance(balanceService.getBalance(id));
            User user1 = userMap.get(2);

            return Arrays.asList(new User[]{user,user1});
        }
        User[] users=new User[]{new User(0,"")};
        List<User> users1 = Arrays.asList(users);
        return users1;

    }
}
