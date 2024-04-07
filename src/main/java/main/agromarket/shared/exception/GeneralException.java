package main.agromarket.shared.exception;

import org.springframework.http.HttpStatus;

public class GeneralException extends RuntimeException{

    private HttpStatus errorCode;
    private String errorMessage;

    public GeneralException(String errorMessage, HttpStatus errorCode){
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
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
