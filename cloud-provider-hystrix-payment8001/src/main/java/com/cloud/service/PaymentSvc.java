package com.cloud.service;

import cn.hutool.core.util.IdUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @date 2021年09月28日
 */
@Service
public class PaymentSvc {

    //服务降级
    public String ok(Integer id){
        return "线程池：  "+Thread.currentThread().getName()+"  paymentInfo_OK,id:  "
                +id+"\t"+"O(∩_∩)O哈哈哈~";
    }

    @HystrixCommand(fallbackMethod = "payment_timeoutHandler",commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "3000")
    })
    public String timeout(Integer id){
        int timeout = 5;
        try {
            TimeUnit.SECONDS.sleep(timeout);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "线程池：  "+Thread.currentThread().getName()+"  paymentInfo_timeout,id:  "
                +id+"\t"+"耗时：";
    }

    public String payment_timeoutHandler(Integer id){
        return "线程池：  "+Thread.currentThread().getName()+"  payment_timeoutHandler,id:  "
                +id+"\t"+"O(∩_∩)O哈哈哈~";
    }

    //服务熔断
    @HystrixCommand(fallbackMethod = "paymentCircuitBreaker_fallback",commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled",value = "true"),
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value = "10"),
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value = "10000"),
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage",value = "60")
    })
    public String paymentCircuitBreaker(Integer id){
        if (id==null||id<0){
            int i =1/0;
            //throw new RuntimeException("id必须大于0");
        }
        return "线程池：  "+Thread.currentThread().getName()+"  paymentInfo_timeout,orderNo:  "
                + IdUtil.fastSimpleUUID();
    }

    public String paymentCircuitBreaker_fallback(Integer id){
        return "paymentCircuitBreaker_fallback,Id不能为负数，Id="+id;
    }


}
