package com.example.accountservice.service;


import com.example.accountservice.pojo.Balance;
import org.springframework.stereotype.Component;

@Component
public class BalanceServiceFallback implements BalanceService {


    @Override
    public Balance getBalance(Integer id) {
        return new Balance(0, 0, 0, "降级");

    }
}
