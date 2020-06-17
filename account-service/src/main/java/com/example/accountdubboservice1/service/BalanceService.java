package com.example.accountdubboservice1.service;

import com.example.accountdubboservice1.pojo.Balance;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author Administrator
 */
@FeignClient(name = "payment-service", fallback = BalanceServiceFallback.class)
public interface BalanceService {

    @RequestMapping(value = "/pay/balance", method = RequestMethod.GET)
    Balance getBalance(@RequestParam("id") Integer id);
}
