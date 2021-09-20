package co.com.sofkau.crud.utils.exception;

public class BusinessException extends RuntimeException{
    private String message;

    public BusinessException(String message) {
        this.message = message;
    }
}
