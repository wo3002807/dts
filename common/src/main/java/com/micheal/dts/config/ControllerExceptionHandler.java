package com.micheal.dts.config;

import com.micheal.dts.exception.BusinessException;
import com.micheal.dts.io.RespCode;
import com.micheal.dts.util.ExpCodeProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.method.HandlerMethod;

/**
 * RequestHandlerException
 */
@ControllerAdvice
public class ControllerExceptionHandler {
    private static Logger log = LoggerFactory.getLogger(ControllerExceptionHandler.class);

    @ResponseBody
    @ExceptionHandler(Throwable.class)
    public RespCode process(HandlerMethod handler, Exception ex) {
        if(ex instanceof BusinessException){//业务异常无需打印
            log.info("业务异常->{}",ex);
            return ExpCodeProperties.getRespCode(((BusinessException) ex).getExpCode());
        }else{//说明未捕获的异常-属于系统异常
            log.error("系统异常->{}",ex);
            return ExpCodeProperties.getRespCode("999999");
        }
    }
}
