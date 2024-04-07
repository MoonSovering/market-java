package main.agromarket.farmer.infrastructure.rest.controller;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import main.agromarket.company.application.create.CreateCompanyRequest;
import main.agromarket.farmer.application.create.CreateFarmerRequest;
import main.agromarket.farmer.application.create.CreateFarmerUseCase;
import main.agromarket.shared.Enum.Status;
import main.agromarket.shared.exception.GeneralException;
import org.hibernate.validator.constraints.Length;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public final class FarmerPutController {
    private CreateFarmerUseCase creator;
    public FarmerPutController(CreateFarmerUseCase creator) {
        this.creator = creator;
    }
    @PutMapping(value = "/farmer/create/{id}")
    public ResponseEntity<String> create(@PathVariable String id, @Valid @RequestBody Request request, BindingResult errorResult){
        if(errorResult.hasErrors()){
            String errorMessage = GeneralException.extractErrorMessage(errorResult);
            throw new GeneralException(errorMessage, HttpStatus.BAD_REQUEST);
        }
        List<CreateFarmerRequest.ContactInfo> companyContacts = request.contact.stream()
                .map(contactDetail -> new CreateFarmerRequest.ContactInfo(
                        contactDetail.contactType(),
                        contactDetail.contact()
                )).toList();
        creator.createFarmer(new CreateFarmerRequest(id, request.userName, request.email,
                request.password, request.lastName, request.address, companyContacts, request.type, Status.FARMER));
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    final static class Request {
        @NotBlank(message = "Username is required")
        @Length(min = 5, max = 15, message = "Username must be between 5 and 15 characters long")
        private String userName;

        @NotBlank(message = "Email is required")
        @Email(message = "Email should be valid")
        private String email;

        @NotBlank(message = "Password is required")
        @Length(min = 8, message = "Password must be at least 8 characters long")
        private String password;

        @NotBlank(message = "Last name is required")
        private String lastName;

        @NotBlank(message = "Address is required")
        private String address;

        @Valid
        private List<ContactDetail> contact;

        @NotBlank(message = "Type is required")
        private String type;

        private Status status;

        public Status status(){return status;}
        public String address() {
            return address;
        }

        public String userName() {
            return userName;
        }

        public String email() {
            return email;
        }

        public String password() {
            return password;
        }

        public String lastName() {
            return lastName;
        }

        public List<ContactDetail> contact() {
            return contact;
        }

        public String type() {
            return type;
        }

        public void setStatus(Status status){this.status = status;}
        public void setContact(List<ContactDetail> contact) {
            this.contact = contact;
        }

        public void setType(String type) {
            this.type = type;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public void setLastName(String status) {
            this.lastName = status;
        }

        public void setAddress(String address) {
            this.address = address;
        }
        final static class ContactDetail{
            @NotNull(message = "Contact type cannot be null")
            @Size(min = 2, message = "Contact type must have at least 2 characters")
            private String contactType;

            @NotNull(message = "Contact cannot be null")
            @Size(min = 2, message = "Contact must have at least 2 characters")
            private String contact;
            public String contactType() {
                return contactType;
            }
            public String contact() {
                return contact;
            }

            public void setContactType(String contactType) {
                this.contactType = contactType;
            }

            public void setContact(String contact) {
                this.contact = contact;
            }
        }
    }
}