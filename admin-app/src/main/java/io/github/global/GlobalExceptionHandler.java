package io.github.global;

import cn.dev33.satoken.exception.NotLoginException;
import io.github.result.ResultCode;
import io.github.result.SimpleResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {


    /**
     * 全局处理 未登录异常
     */
    @ExceptionHandler(value = {NotLoginException.class})
    public SimpleResult<Void> handleNoLoginExceptions(NotLoginException ignoredEx) {
        return SimpleResult.buildError(ResultCode.NO_LOGIN);
    }


    /**
     * 全局处理 未登录异常
     */
    @ExceptionHandler(value = {Exception.class})
    public SimpleResult<Void> handleOtherExceptions(Exception ignoredEx) {
        return SimpleResult.buildError(ResultCode.ERROR);
    }
}