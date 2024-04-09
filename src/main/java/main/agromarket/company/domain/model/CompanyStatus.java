package main.agromarket.company.domain.model;

import com.fasterxml.jackson.annotation.JsonValue;
import main.agromarket.shared.valueObject.StringValueObject;

public class CompanyStatus extends StringValueObject {
    public CompanyStatus(String value) {
        super(String.valueOf(value));
    }
    @JsonValue
    @Override
    public String value() {
        return super.value();
    }
}
