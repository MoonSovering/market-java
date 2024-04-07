package main.agromarket.farmer.domain.model;

import com.fasterxml.jackson.annotation.JsonValue;
import main.agromarket.shared.valueObject.StringValueObject;

public class FarmerLastName extends StringValueObject {
    public FarmerLastName(String value){
        super(value);
        ensureIsValidLength(value);
    }
    private void ensureIsValidLength(String value){
        if(value.length() <= 1){
            throw new IllegalArgumentException("Last name must have more than two characters. ");
        }
    }
    @JsonValue
    @Override
    public String value() {
        return super.value();
    }
}