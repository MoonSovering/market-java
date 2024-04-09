package main.agromarket.farmer.domain.model;

import com.fasterxml.jackson.annotation.JsonValue;
import main.agromarket.shared.valueObject.Identifier;
import main.agromarket.shared.valueObject.StringValueObject;

public class FarmerContact {
    private final String typeContact;
    private final String contact;

    public FarmerContact(String typeContact, String contact) {
        ensureIsValidLength(typeContact, contact);
        this.typeContact = typeContact;
        this.contact = contact;
    }

    public String getTypeContact() {
        return typeContact;
    }

    public String getContact() {
        return contact;
    }

    private void ensureIsValidLength(String typeContact, String contact){
        if(typeContact.length() <= 1){
            throw new IllegalArgumentException("Type Contact must have more than two characters. ");
        }
        if(contact.length() <= 1){
            throw new IllegalArgumentException("Contact must have more than two characters. ");
        }
    }
}
