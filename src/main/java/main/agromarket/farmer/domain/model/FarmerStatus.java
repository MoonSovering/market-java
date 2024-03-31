package main.agromarket.farmer.domain.model;

import main.agromarket.shared.Enum.Status;
import main.agromarket.shared.valueObject.StringValueObject;

public class FarmerStatus extends StringValueObject {
    public FarmerStatus(Status value) {
        super(String.valueOf(value));
    }
}
