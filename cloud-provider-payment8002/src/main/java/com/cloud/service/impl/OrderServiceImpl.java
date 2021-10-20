package com.cloud.service.impl;

import com.cloud.dao.OrderMapper;
import com.cloud.model.BxxOrder;
import com.cloud.service.OrderService;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @date 2021年08月20日
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Resource
    private OrderMapper orderMapper;

    @Override
    public BxxOrder getOrderById(@Param("id") Integer id) {
        return orderMapper.findOrderByIds(id);
    }
}
