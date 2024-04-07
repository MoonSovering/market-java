package main.agromarket.shared.exception;

import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;

import java.util.stream.Collectors;

public class GeneralException extends RuntimeException{

    private HttpStatus errorCode;
    private String errorMessage;

    public GeneralException(String errorMessage, HttpStatus errorCode){
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }
    public static String extractErrorMessage(BindingResult errorResult) {
        return errorResult.getAllErrors().stream()
                .map(ObjectError::getDefaultMessage)
                .collect(Collectors.joining(", "));
    }
    public GeneralException(){
    }

    public HttpStatus getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(HttpStatus errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
