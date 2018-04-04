package com.mcqueen.mcqueen.base;

/**
 * Created by gfl on 2018/4/4 15:49
 * Email:gfl@cheok.com.
 */
public class McQueenException extends RuntimeException {
    public McQueenException() {
    }

    public McQueenException(String message, Throwable cause) {
        super(message, cause);
    }

    public McQueenException(String message) {
        super(message);
    }

    public McQueenException(Throwable cause) {
        super(cause);
    }
}
