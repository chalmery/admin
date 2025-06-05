package io.github.common.utils;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

public class WebUtils {


    public static String getCurrentHttpMethod() {
        try {
            ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
            if (attributes != null) {
                return attributes.getRequest().getMethod();
            }
        } catch (Exception ignoreEx) {
            // ignore
        }
        return "UNKNOWN";
    }
}
