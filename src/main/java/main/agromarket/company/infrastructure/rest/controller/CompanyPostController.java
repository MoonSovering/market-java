package main.agromarket.company.infrastructure.rest.controller;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import main.agromarket.company.application.create.CreateCompanyRequest;
import main.agromarket.company.application.create.CreateCompanyUseCase;
import main.agromarket.company.domain.ports.response.CompanyResponseDto;
import main.agromarket.shared.Enum.Status;
import main.agromarket.shared.exception.GeneralException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
public class CompanyPostController {
    private final CreateCompanyUseCase create;
    public CompanyPostController(CreateCompanyUseCase create) {
        this.create = create;
    }
    @PostMapping("company")
    public ResponseEntity<CompanyResponseDto> create(@Valid @RequestBody Request request, BindingResult errorResult){
        if(errorResult.hasErrors()){
            String errorMessage = GeneralException.extractErrorMessage(errorResult);
            throw new GeneralException(errorMessage, HttpStatus.BAD_REQUEST);
        }
        List<CreateCompanyRequest.ContactInfo> companyContacts = request.contact.stream()
                .map(contactDetail -> new CreateCompanyRequest.ContactInfo(
                        contactDetail.contactType(),
                        contactDetail.contact()
                )).toList();
        CompanyResponseDto result = create.createCompany(new CreateCompanyRequest(request.name, companyContacts, request.Address, request.email, request.password, Status.COMPANY
        ));
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }
    final static class Request{

        @NotNull(message = "Name cannot be null")
        @Size(min = 1, message = "Name must not be empty")
        private String name;

        @Valid
        private List<ContactDetail> contact;

        @NotNull(message = "Address cannot be null")
        @Size(min = 1, message = "Address must not be empty")
        private String Address;

        @NotNull(message = "Email cannot be null")
        @Email(message = "Email should be valid")
        private String email;

        @NotNull(message = "Password cannot be null")
        @Size(min = 8, message = "Password must have at least 8 characters")
        private String password;
        private Status status;

        public String name() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public List<ContactDetail> contact() {
            return contact;
        }

        public void setContact(List<ContactDetail> contact) {
            this.contact = contact;
        }

        public String address() {
            return Address;
        }

        public void setAddress(String address) {
            Address = address;
        }

        public String email() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String password() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public Status status() {
            return status;
        }

        public void setStatus(Status status) {
            this.status = status;
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
