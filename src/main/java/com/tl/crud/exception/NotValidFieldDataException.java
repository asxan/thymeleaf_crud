package com.tl.crud.exception;

public class NotValidFieldDataException extends RuntimeException {
    public NotValidFieldDataException(String msg){
        super(msg);
    }
}
