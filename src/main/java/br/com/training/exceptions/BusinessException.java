package br.com.training.exceptions;

public class BusinessException extends RuntimeException{
    public BusinessException(String message){
        super(message);
    }
}
