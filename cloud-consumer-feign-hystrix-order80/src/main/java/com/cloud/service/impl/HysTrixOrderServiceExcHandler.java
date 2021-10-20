package com.cloud.service.impl;

import com.cloud.service.HystrixOrderService;
import org.springframework.stereotype.Component;

/**
 * @date 2021年09月29日
 */
@Component
public class HysTrixOrderServiceExcHandler implements HystrixOrderService {
    @Override
    public String ok(Integer id) {
        return "HysTrixOrderServiceExcHandler-ok,id : "+id;
    }

    @Override
    public String timeout(Integer id) {
        return "HysTrixOrderServiceExcHandler-timeout,id : "+id;
    }
}
