package com.cloud.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @date 2021年08月19日
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonResult <T>{

    private Integer code;
    private String msg;
    private T data;

    public CommonResult(Integer code, String msg){
        this(code,msg,null);
    }

    public static <T> CommonResult success(T t){
        return new CommonResult(ResultEnum.OK.getCode(),ResultEnum.OK.getMsg(),t);
    }

    public static <T> CommonResult success(String msg,T t){
        return new CommonResult(ResultEnum.OK.getCode(),msg,t);
    }

    public static <T> CommonResult fail(T t){
        return new CommonResult(ResultEnum.ERROE.getCode(),ResultEnum.ERROE.getMsg(),t);
    }

    public static <T> CommonResult fail(String msg,T t){
        return new CommonResult(ResultEnum.ERROE.getCode(),msg,t);
    }

}
