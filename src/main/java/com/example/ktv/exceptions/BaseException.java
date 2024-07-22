package com.example.ktv.exceptions;

public abstract class BaseException extends Exception {
    public BaseException(String code){
        super(code);
    }
}
