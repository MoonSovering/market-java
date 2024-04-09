package main.agromarket.farmer.domain.model;

import com.fasterxml.jackson.annotation.JsonValue;
import main.agromarket.shared.exception.FarmerException;
import main.agromarket.shared.valueObject.StringValueObject;
import org.springframework.http.HttpStatus;

import static main.agromarket.shared.constant.Constant.PASSWORD_PATTERN;

public class FarmerPassword extends StringValueObject {
    public FarmerPassword(String value) {
        super(value);
        ensureIsValidPassword(value);
    }
    private void ensureIsValidPassword(String value) {
        if (value == null || !PASSWORD_PATTERN.matcher(value).matches()) {
            throw new FarmerException("The password is not valid. It must contain at least 6 characters, " +
                    "one uppercase letter, one lowercase letter, one number, and one special character.", HttpStatus.BAD_REQUEST);
        }
    }
    @JsonValue
    @Override
    public String value() {
        return super.value();
    }
}
