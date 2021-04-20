package com.ada.adalibrary.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.UNAUTHORIZED)
public class UsAuthException extends RuntimeException{
    public UsAuthException(String message){

        super(message);
    }
}
