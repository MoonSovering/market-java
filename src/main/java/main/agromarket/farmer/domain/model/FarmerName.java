package main.agromarket.farmer.domain.model;

import com.fasterxml.jackson.annotation.JsonValue;
import main.agromarket.shared.exception.FarmerException;
import main.agromarket.shared.valueObject.StringValueObject;
import org.springframework.http.HttpStatus;

public class FarmerName extends StringValueObject {
    public FarmerName(String value) {
        super(value);
        ensureIsValidLength(value);
    }
    private void ensureIsValidLength(String value){
        if(value.length() <= 1){
            throw new FarmerException("Name must have more than two characters. ", HttpStatus.BAD_REQUEST);
        }
    }
    @JsonValue
    @Override
    public String value() {
        return super.value();
    }
}
