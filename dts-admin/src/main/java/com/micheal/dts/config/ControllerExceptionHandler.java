package com.micheal.dts.config;

import com.micheal.dts.entity.io.base.ResultCode;
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
    public ResultCode process(HandlerMethod handler, Exception ex) {
        log.error("异常-{}", ex);
        return new ResultCode();
    }
}
