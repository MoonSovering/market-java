package main.agromarket.farmer.domain.model;

import com.fasterxml.jackson.annotation.JsonValue;
import main.agromarket.shared.exception.FarmerException;
import main.agromarket.shared.valueObject.StringValueObject;
import org.springframework.http.HttpStatus;

import static main.agromarket.shared.constant.Constant.EMAIL_PATTERN;

public class FarmerEmail extends StringValueObject {
    public FarmerEmail(String value) {
        super(value);
        ensureIsValidEmail(value);
    }
    private void ensureIsValidEmail(String value) {
        if (value == null || !EMAIL_PATTERN.matcher(value).matches()) {
            throw new FarmerException("Invalid email.", HttpStatus.BAD_REQUEST);
        }
    }
    @JsonValue
    @Override
    public String value() {
        return super.value();
    }
}
