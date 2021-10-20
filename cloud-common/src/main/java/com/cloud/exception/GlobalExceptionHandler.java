package com.cloud.exception;

import com.cloud.common.CommonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.stream.Collectors;

/**
 * 全局异常处理
 */
@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ResponseBody
    @ExceptionHandler(value = ApiException.class)
    public CommonResult handleApiException(ApiException e) {
        log.error("出现异常:{}", e);
        if (e.getErrorCode() != null) {
            return CommonResult.fail(e.getErrorCode());
        }
        return CommonResult.fail(e.getMessage());
    }

    @ResponseBody
    @ExceptionHandler(value = BizException.class)
    public CommonResult handleBizException(BizException e) {
        log.error("出现异常:{}", e);
        if (e.getErrorCode() != null) {
            return CommonResult.fail(e.getErrorCode());
        }
        return CommonResult.fail(e.getMessage());
    }

//    @ResponseBody
//    @ExceptionHandler(value = MethodArgumentNotValidException.class)
//    public CommonResult handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
//        log.error("出现异常:{}", e);
//        String message = getBindingResultMsg(e.getBindingResult());
//        return CommonResult.validateFailed(message);
//    }
//
//    @ResponseBody
//    @ExceptionHandler(value = BindException.class)
//    public CommonResult handleBindException(BindException e) {
//        log.error("出现异常:{}", e);
//        String message = getBindingResultMsg(e.getBindingResult());
//        return CommonResult.validateFailed(message);
//    }
//
//    @ResponseBody
//    @ExceptionHandler(ConstraintViolationException.class)
//    public CommonResult constraintViolationException(ConstraintViolationException e) {
//        log.error("出现异常:{}", e);
//        String msg = e.getConstraintViolations().stream()
//                .map(ConstraintViolation::getMessage)
//                .collect(Collectors.joining(","));
//        return CommonResult.validateFailed(msg);
//    }


    @ResponseBody
    @ExceptionHandler(Throwable.class)
    public CommonResult exception(Throwable e) {
        log.error("出现异常:{}", e);
        return CommonResult.fail(e.getMessage());
    }

    private String getBindingResultMsg(BindingResult result) {
        return result.getAllErrors().stream()
                .map(DefaultMessageSourceResolvable::getDefaultMessage)
                .collect(Collectors.joining(","));
    }

}
