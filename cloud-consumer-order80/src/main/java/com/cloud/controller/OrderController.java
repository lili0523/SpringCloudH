package com.cloud.controller;


import com.cloud.common.CommonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;


/**
 * @date 2021年09月17日
 */
@RestController
@RequestMapping(value = "/order")
public class OrderController {

    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/test")
    public CommonResult test(Integer id){
        String url = "http://cloud-payment-service/payment/getOrder/"+id;
        ResponseEntity<CommonResult> forEntity = restTemplate.getForEntity(url, CommonResult.class);
        return forEntity.getBody();
    }

}
