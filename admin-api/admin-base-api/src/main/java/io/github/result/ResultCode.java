package io.github.result;

import lombok.Getter;

@Getter
public enum ResultCode {

    SUCCESS(0, "成功"),
    ERROR(2000, "服务端异常"),
    NO_LOGIN(2001, "您未登录"),
    ;
    public final Integer code;
    public final String message;

    ResultCode(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
