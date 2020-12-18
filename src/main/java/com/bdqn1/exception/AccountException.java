package com.bdqn1.exception;

public class AccountException extends RuntimeException{
  //RuntimeException默认是对所有运行时的异常
    public AccountException() {
    }

    public AccountException(String message) {
        super(message);
    }

    public AccountException(String message, Throwable cause) {
        super(message, cause);
    }

    public AccountException(Throwable cause) {
        super(cause);
    }
}
