package com.cloud.controller;

import com.cloud.service.PaymentSvc;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @date 2021年09月28日
 */
@RestController
@RequestMapping("/payment")
public class PaymentController {

    @Resource
    private PaymentSvc paymentSvc;

    @Value("${server.port}")
    private String serverPort;

    @RequestMapping("/paymentok/{id}")
    public String ok(@PathVariable("id") Integer id){
        return paymentSvc.ok(id);
    }

    @RequestMapping("/paymenttimeout/{id}")
    public String timeout(@PathVariable("id") Integer id){
        return paymentSvc.timeout(id);
    }

    @RequestMapping("/paymentCircuitBreaker")
    public String paymentCircuitBreaker(Integer id){
        return paymentSvc.paymentCircuitBreaker(id);
    }
}
