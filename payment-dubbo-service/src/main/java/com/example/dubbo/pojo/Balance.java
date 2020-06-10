package com.example.dubbo.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.io.Serializable;

@Data
public class Balance implements Serializable {
    private int id;
    private int diamond;
    private int ticket;
    private String message;

    public Balance() {
    }

    public Balance(int id, int diamond, int ticket) {
        this(id, diamond, ticket, "OK");
    }

    public Balance(int id, int diamond, int ticket, String message) {
        this.id = id;
        this.diamond = diamond;
        this.ticket = ticket;
        this.message = message;
    }

}
