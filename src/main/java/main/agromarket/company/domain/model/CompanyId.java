package main.agromarket.company.domain.model;

import com.fasterxml.jackson.annotation.JsonValue;
import main.agromarket.shared.valueObject.Identifier;

public final class CompanyId extends Identifier {

    public CompanyId(String value){
        super(value);
    }
    @JsonValue
    @Override
    public String value(){
        return super.value();
    }
}
