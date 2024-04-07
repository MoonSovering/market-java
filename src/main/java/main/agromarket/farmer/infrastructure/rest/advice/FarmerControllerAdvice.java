package main.agromarket.farmer.infrastructure.rest.advice;

import main.agromarket.shared.exception.GeneralException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class FarmerControllerAdvice {
    @ExceptionHandler(GeneralException.class)
    public ResponseEntity<String> handleFarmerException(GeneralException e) {
        return new ResponseEntity<>(e.getErrorMessage(), e.getErrorCode());
    }
}
