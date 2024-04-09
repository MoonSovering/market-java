package main.agromarket.company.domain.model;

import com.fasterxml.jackson.annotation.JsonValue;
import main.agromarket.shared.valueObject.StringValueObject;

import static main.agromarket.shared.constant.Constant.PASSWORD_PATTERN;

public class CompanyPassword extends StringValueObject {
    public CompanyPassword(String value) {
        super(value);
        ensureIsValidPassword(value);
    }

    private void ensureIsValidPassword(String value) {
        if (value == null || !PASSWORD_PATTERN.matcher(value).matches()) {
            throw new IllegalArgumentException("The password is not valid. It must contain at least 6 characters, " +
                    "one uppercase letter, one lowercase letter, one number, and one special character.");
        }
    }
    @JsonValue
    @Override
    public String value() {
        return super.value();
    }
}
