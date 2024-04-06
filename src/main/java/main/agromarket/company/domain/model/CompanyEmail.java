package main.agromarket.company.domain.model;

import com.fasterxml.jackson.annotation.JsonValue;
import main.agromarket.shared.valueObject.StringValueObject;

import static main.agromarket.shared.constant.Constant.EMAIL_PATTERN;

public class CompanyEmail extends StringValueObject {
    public CompanyEmail(String value) {
        super(value);
        ensureIsValidEmail(value);
    }
    private void ensureIsValidEmail(String value) {
        if (value == null || !EMAIL_PATTERN.matcher(value).matches()) {
            throw new IllegalArgumentException("Invalid email.");
        }
    }
    @JsonValue
    @Override
    public String value() {
        return super.value();
    }
}
