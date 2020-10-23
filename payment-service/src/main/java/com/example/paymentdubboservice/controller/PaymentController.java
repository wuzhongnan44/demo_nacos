package com.example.paymentdubboservice.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.example.paymentdubboservice.pojo.Balance;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController

public class PaymentController {

    @Value("${sleep:0}")
    private int sleep;
    @Value("${stay}")
    private int stay;
    private int c;

    final static Map<Integer, Balance> balanceMap = new HashMap() {
        {
            put(1, new Balance(1, 10, 1000));
            put(2, new Balance(2, 0, 10000));
            put(3, new Balance(3, 100, 0));
        }
    };

    /**
     * @
     * @param id
     * @return
     */
    @RequestMapping("/pay/balance")
    @SentinelResource(value = "protected-resource", blockHandler = "handleBlock")
    public Balance getBalance1(Integer id) {
        System.out.println("request: /pay/balance?id=" + id + ", sleep: " + sleep + "stay：" + stay);
        long l = System.currentTimeMillis();
        if (sleep > 0) {
            try {
                Thread.sleep(sleep);
            } catch (InterruptedException e) {
                e.printStackTrace();
                System.out.println(1231232313);
            }
        }
        if (id != null && balanceMap.containsKey(id)) {
            return balanceMap.get(id);
        }
        return new Balance(0, 0, 0);
    }


    public Balance handleBlock(Integer id, BlockException e) {
        return new Balance(0, 0, 0, "限流");
    }

}
