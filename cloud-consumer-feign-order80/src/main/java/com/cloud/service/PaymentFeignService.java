package com.cloud.service;

import com.cloud.common.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Component
@FeignClient(value = "CLOUD-PAYMENT-SERVICE")
public interface PaymentFeignService {

    @RequestMapping("/payment/getOrder/{id}")
    CommonResult getPaymentOrder(@PathVariable("id") Long id);

    @GetMapping("/payment/getFeignTimeout")
    String getFeignTimeout();
}
