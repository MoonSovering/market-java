package main.agromarket.farmer.domain.model;

import com.fasterxml.jackson.annotation.JsonValue;
import main.agromarket.shared.Enum.Status;
import main.agromarket.shared.valueObject.StringValueObject;

public class FarmerStatus extends StringValueObject {
    public FarmerStatus(Status value) {
        super(String.valueOf(value));
    }
    @JsonValue
    @Override
    public String value() {
        return super.value();
    }
}
