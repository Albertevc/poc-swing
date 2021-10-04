package br.com.aevc.pocswing.service.exception;

public class SystemException extends Exception {

    public SystemException(String message, Throwable throwable){
        super(message, throwable);
    }
}
