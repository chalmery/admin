package io.github.global;

import cn.dev33.satoken.exception.NotLoginException;
import cn.dev33.satoken.exception.SaTokenException;
import io.github.common.utils.ExceptionUtils;
import io.github.common.utils.WebUtils;
import io.github.result.HttpStatus;
import io.github.result.SimpleResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpMethod;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    /**
     * 全局处理
     */
    @ExceptionHandler(value = {Exception.class})
    public SimpleResult<Void> handleOtherExceptions(Exception ex) {
        log.error("handleOtherExceptions-error {}", ExceptionUtils.toString(ex));
        //方法不对
        if (ex instanceof HttpRequestMethodNotSupportedException) {
            String currentHttpMethod = WebUtils.getCurrentHttpMethod();
            if (HttpMethod.GET.toString().equals(currentHttpMethod)) {
                return SimpleResult.buildError(HttpStatus.HTTP_BAD_METHOD, "当前请求方法不支持GET");
            } else if (HttpMethod.POST.toString().equals(currentHttpMethod)) {
                return SimpleResult.buildError(HttpStatus.HTTP_BAD_METHOD, "当前请求方法不支持POST");
            } else {
                return SimpleResult.buildError(HttpStatus.HTTP_BAD_METHOD, "当前请求方法不支持");
            }
        }
        //saToken异常
        else if (ex instanceof SaTokenException) {
            //未登录
            if (ex instanceof NotLoginException) {
                return SimpleResult.buildError(HttpStatus.HTTP_UNAUTHORIZED, ex.getMessage());
            }
        }

        return SimpleResult.buildError(HttpStatus.HTTP_INTERNAL_ERROR, "服务端异常");
    }
}