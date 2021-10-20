package com.cloud.exception;


import com.cloud.common.IErrorCode;

/**
 * 自定义API异常
 */
public class BizException extends RuntimeException {
    private IErrorCode errorCode;

    public BizException(IErrorCode errorCode) {
        super(errorCode.getMessage());
        this.errorCode = errorCode;
    }

    public BizException(String message) {
        super(message);
    }

    public BizException(Throwable cause) {
        super(cause);
    }

    public BizException(String message, Throwable cause) {
        super(message, cause);
    }

    public IErrorCode getErrorCode() {
        return errorCode;
    }
}
