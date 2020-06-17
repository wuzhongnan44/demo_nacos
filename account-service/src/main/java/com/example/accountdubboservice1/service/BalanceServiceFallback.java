package com.example.accountdubboservice1.service;


import com.example.accountdubboservice1.pojo.Balance;
import org.springframework.stereotype.Component;

/**
 * @author Administrator
 */
@Component
public class BalanceServiceFallback implements BalanceService {


    @Override
    public Balance getBalance(Integer id) {
        return new Balance(0, 0, 0, "降级");

    }
}
