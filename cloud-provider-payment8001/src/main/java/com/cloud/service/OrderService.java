package com.cloud.service;

import com.cloud.model.BxxOrder;
import org.apache.ibatis.annotations.Param;

public interface OrderService {

    BxxOrder getOrderById(@Param("id") Integer id);

}
