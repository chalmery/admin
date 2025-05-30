package io.github.infrastructure.utils;

public class ExceptionUtils {


    public static String toString(Throwable throwable) {
        // 获取完整的异常堆栈信息字符串
        String stackTrace = org.apache.commons.lang3.exception.ExceptionUtils.getStackTrace(throwable);
        // 如果堆栈信息超过 4096 字符，则截断
        if (stackTrace.length() > 4096) {
            stackTrace = stackTrace.substring(0, 4096);
        }
        return stackTrace;
    }
}
