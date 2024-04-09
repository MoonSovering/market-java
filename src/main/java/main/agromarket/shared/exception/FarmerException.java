package main.agromarket.shared.exception;

import org.springframework.http.HttpStatus;

public class FarmerException extends RuntimeException{

    private HttpStatus errorCode;
    private String errorMessage;

    public FarmerException(String errorMessage, HttpStatus errorCode){
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }
    public FarmerException(){
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
