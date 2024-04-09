package main.agromarket.farmer.domain.model;

import com.fasterxml.jackson.annotation.JsonValue;
import main.agromarket.shared.valueObject.Identifier;
import main.agromarket.shared.valueObject.StringValueObject;

public class FarmerContact extends Identifier {
    public FarmerContact(String value){
        super(value);
    }
    @JsonValue
    @Override
    public String value() {
        return super.value();
    }
}
