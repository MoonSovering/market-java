package main.agromarket.farmer.infrastructure.rest.advice;

import main.agromarket.shared.exception.FarmerException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class FarmerControllerAdvice {
    @ExceptionHandler(FarmerException.class)
    public ResponseEntity<String> handleFarmerException(FarmerException e) {
        return new ResponseEntity<>(e.getErrorMessage(), e.getErrorCode());
    }
}
