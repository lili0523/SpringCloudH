package com.cloud.service;

import com.cloud.service.impl.HysTrixOrderServiceExcHandler;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Component
@FeignClient(value = "CLOUD-HYSTRIX-PAYMENT-SERVICE",fallback = HysTrixOrderServiceExcHandler.class)
public interface HystrixOrderService {

    @RequestMapping("/payment/paymentok/{id}")
    String ok(@PathVariable("id") Integer id);

    @RequestMapping("/payment/paymenttimeout/{id}")
    String timeout(@PathVariable("id") Integer id);
}
