package io.github.result;

import lombok.Data;
import lombok.EqualsAndHashCode;


@EqualsAndHashCode(callSuper = true)
@Data
@SuppressWarnings("unused")
public class SimpleResult<T> extends BaseResult {

    private T data;


    public static <T> SimpleResult<T> buildSuccess(T data) {
        SimpleResult<T> result = new SimpleResult<>();
        result.setCode(HttpStatus.HTTP_OK);
        result.setMessage("请求成功");
        result.setSuccess(true);
        result.setData(data);
        return result;
    }

    public static <T> SimpleResult<T> buildSuccess() {
        SimpleResult<T> result = new SimpleResult<>();
        result.setCode(HttpStatus.HTTP_OK);
        result.setMessage("请求成功");
        result.setSuccess(true);
        return result;
    }

    public static <T> SimpleResult<T> buildError() {
        SimpleResult<T> result = new SimpleResult<>();
        result.setCode(HttpStatus.HTTP_INTERNAL_ERROR);
        result.setMessage("服务端异常");
        result.setSuccess(false);
        return result;
    }


    public static <T> SimpleResult<T> buildError(String message) {
        SimpleResult<T> result = new SimpleResult<>();
        result.setCode(HttpStatus.HTTP_INTERNAL_ERROR);
        result.setMessage(message);
        result.setSuccess(false);
        return result;
    }


    public static <T> SimpleResult<T> buildError(Integer httpStatus, String message) {
        SimpleResult<T> result = new SimpleResult<>();
        result.setCode(httpStatus);
        result.setMessage(message);
        result.setSuccess(false);
        return result;
    }

}
