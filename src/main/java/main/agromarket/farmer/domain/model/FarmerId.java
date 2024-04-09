package main.agromarket.farmer.domain.model;

import com.fasterxml.jackson.annotation.JsonValue;
import main.agromarket.shared.valueObject.Identifier;

public final class FarmerId extends Identifier {
    public FarmerId(String value){
        super(value);
    }
    @JsonValue
    @Override
    public String value(){
        return super.value();
    }
}
