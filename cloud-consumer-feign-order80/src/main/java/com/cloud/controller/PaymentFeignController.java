package com.cloud.controller;

import com.cloud.common.CommonResult;
import com.cloud.service.PaymentFeignService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @date 2021年09月27日
 */
@RestController
@RequestMapping("/paymentFeign")
public class PaymentFeignController {

    @Resource
    PaymentFeignService paymentFeignService;

    @GetMapping("/testFeign")
    public CommonResult testFeign(Long id){
        return paymentFeignService.getPaymentOrder(id);
    }

    @GetMapping("/testFeignTimeout")
    public String testFeignTimeout(){
        return paymentFeignService.getFeignTimeout();
    }
}
