package com.cloud.common;


public enum ResultEnum {

    OK(1,"成功"),
    ERROE(2,"失败"),

    ;

    private Integer code;
    private String msg;

    private ResultEnum(Integer code,String msg){
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode(){
        return code;
    }

    public String getMsg(){
        return msg;
    }

}
