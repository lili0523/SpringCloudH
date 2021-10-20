package com.cloud.controller;

import com.cloud.service.HystrixOrderService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @date 2021年09月28日
 */
@RestController
@RequestMapping("/order")
//@DefaultProperties(defaultFallback = "globalTimeoutAndExceptionHandler",commandProperties = {
//        @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "3000")
//})
public class HystrixOrderController {

    @Resource
    private HystrixOrderService histrixOrderService;

    @RequestMapping("/testOk/{id}")
    @HystrixCommand
    public String testOk(@PathVariable("id") Integer id){
        return histrixOrderService.ok(id);
    }

    @RequestMapping("/testTimeout/{id}")
//    @HystrixCommand(fallbackMethod = "orderTimeoutHandler", commandProperties = {
//            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "2000")
//    })
    @HystrixCommand
    public String testTimeout(@PathVariable("id") Integer id){
        return histrixOrderService.timeout(id);
    }

    public String orderTimeoutHandler(Integer id){
        return "线程池：  "+Thread.currentThread().getName()+"  orderTimeoutHandler,id:  "
                +id+"\t"+"O(∩_∩)O哈哈哈~";
    }

    public String globalTimeoutAndExceptionHandler(){
        return  "线程池："+Thread.currentThread().getName()+"   globalTimeoutAndExceptionHandler"+"\t"+"┭┮﹏┭┮";
    }

}
