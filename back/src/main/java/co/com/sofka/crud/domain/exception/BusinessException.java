package co.com.sofka.crud.domain.exception;

public class BusinessException extends RuntimeException{
    private String message;

    public BusinessException(String message) {
        this.message = message;
    }
}
