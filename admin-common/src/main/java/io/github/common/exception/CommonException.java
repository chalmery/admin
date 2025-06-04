package io.github.common.exception;


import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class CommonException extends RuntimeException {

    private static final String SERVER_ERROR_MESSAGE = "服务器异常";


    private Integer code;

    private String msg;

    public CommonException() {
        super(SERVER_ERROR_MESSAGE);
        this.code = 500;
        this.msg = SERVER_ERROR_MESSAGE;
    }

}
