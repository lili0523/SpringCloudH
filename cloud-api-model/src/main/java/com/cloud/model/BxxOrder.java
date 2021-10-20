package com.cloud.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @date 2021年08月19日
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BxxOrder {

    private Integer id;
    private Integer userId;
    private String orderNo;
    private String payStatus;

}
