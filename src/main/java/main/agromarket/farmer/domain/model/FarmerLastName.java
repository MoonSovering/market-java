package main.agromarket.farmer.domain.model;

import main.agromarket.shared.exception.FarmerException;
import main.agromarket.shared.valueObject.StringValueObject;
import org.springframework.http.HttpStatus;

public class FarmerLastName extends StringValueObject {
    public FarmerLastName(String value){
        super(value);
        ensureString(value);
    }

    private void ensureString(String value){
        if (!value.matches("[a-zA-Z]+")) {
            throw new FarmerException("Invalid lastName.", HttpStatus.BAD_REQUEST);
        }
    }
}
