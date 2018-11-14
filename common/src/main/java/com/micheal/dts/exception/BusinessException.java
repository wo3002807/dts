package com.micheal.dts.exception;

/**
 * 自定义异常-即业务系统
 */
public class BusinessException extends RuntimeException{
    private String expCode;

    public BusinessException(String expCode) {
        super();
        this.expCode = expCode;

    }

    public String getExpCode() {
        return expCode;
    }
}
