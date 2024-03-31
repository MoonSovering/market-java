package main.agromarket.farmer.domain.model;

import main.agromarket.shared.exception.FarmerException;
import main.agromarket.shared.valueObject.StringValueObject;
import org.springframework.http.HttpStatus;

public class FarmerLastName extends StringValueObject {
    public FarmerLastName(String value){
        super(value);
        ensureIsValidLength(value);
    }
    private void ensureIsValidLength(String value){
        if(value.length() <= 1){
            throw new FarmerException("Last name must have more than two characters. ", HttpStatus.BAD_REQUEST);
        }
    }
}