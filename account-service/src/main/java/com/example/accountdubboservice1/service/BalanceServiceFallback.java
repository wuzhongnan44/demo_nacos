package com.example.accountdubboservice.service;


import com.example.accountdubboservice.pojo.Balance;
import org.springframework.stereotype.Component;

/**
 * @author Administrator
 */
@Component
public class BalanceServiceFallback implements com.example.accountdubboservice.service.BalanceService {


    @Override
    public Balance getBalance(Integer id) {
        return new Balance(0, 0, 0, "降级");

    }
}
