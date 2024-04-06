package main.agromarket.company.domain.model;

import com.fasterxml.jackson.annotation.JsonValue;
import main.agromarket.shared.valueObject.StringValueObject;

public class CompanyAddress extends StringValueObject {
    public CompanyAddress(String value) {
        super(value);
        ensureIsValidLength(value);
    }
    private void ensureIsValidLength(String value){
        if(value.length() <= 1){
            throw new IllegalArgumentException("Address must have more than two characters. ");
        }
    }
    @JsonValue
    @Override
    public String value() {
        return super.value();
    }
}
