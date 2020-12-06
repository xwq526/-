package org.example.exception;

import lombok.Getter;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: xuwenqing
 * Date: 2020-12-02
 * Time: 17:10:26
 */
@Getter
public class AppException extends RuntimeException {
    private String code;//保存抛异常时给定的错误码

    public AppException(String code ,String message) {
//        super(message);
//        this.code = code;
        this(code,message,null);
    }

    public AppException(String code , String message, Throwable cause) {
        super(message, cause);
        this.code = code;
    }
}
