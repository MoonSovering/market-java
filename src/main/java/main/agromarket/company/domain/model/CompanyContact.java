package main.agromarket.company.domain.model;

import main.agromarket.shared.valueObject.StringValueObject;

public class CompanyContact  {
    private final String typeContact;
    private final String contact;

    public CompanyContact(String typeContact, String contact) {
        ensureIsValidLength(typeContact, contact);
        this.typeContact = typeContact;
        this.contact = contact;
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
