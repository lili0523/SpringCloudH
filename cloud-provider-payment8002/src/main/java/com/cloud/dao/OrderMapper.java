package com.cloud.dao;

import com.cloud.model.BxxOrder;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface OrderMapper {

    BxxOrder findOrderByIds(@Param("id") Integer id);

}
