package com.cloud.controller;

import com.cloud.common.CommonResult;
import com.cloud.model.BxxOrder;
import com.cloud.service.OrderService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @date 2021年08月20日
 */
@RestController
@RequestMapping("/payment")
public class PaymentController {

    @Resource
    private OrderService orderService;

    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/getOrder/{id}")
    public CommonResult getOrder(@PathVariable("id") Integer id){
        BxxOrder order = orderService.getOrderById(id);
        return CommonResult.success("查询成功，serverPort："+serverPort,order);
    }

    @GetMapping("/getFeignTimeout")
    public String getFeignTimeout(){
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return serverPort;
    }

    @GetMapping("/lb")
    public String testGateway(){
        return "testGateway"+serverPort;
    }
}
