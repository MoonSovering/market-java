package main.agromarket.shared.valueObject;

import main.agromarket.shared.exception.FarmerException;
import org.springframework.http.HttpStatus;

import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

public abstract class Identifier implements Serializable {
    final protected String value;

    public Identifier(String value) {
        ensureValidUuid(value);

        this.value = value;
    }

    protected Identifier() {
        this.value = null;
    }

    public String value() {
        return value;
    }

    private void ensureValidUuid(String value){
        try {
            UUID.fromString(value);
        } catch (IllegalArgumentException e) {
            throw new FarmerException("Invalid ID. " , HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Identifier that = (Identifier) o;
        return value.equals(that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
