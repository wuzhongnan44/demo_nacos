package com.example.dubbo.pojo;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class UserJson implements Serializable {
    String id;
    List<User> userList;

    public UserJson(String id, List<User> userList) {
        this.id = id;
        this.userList = userList;
    }

    public UserJson() {
    }

    ;
}
