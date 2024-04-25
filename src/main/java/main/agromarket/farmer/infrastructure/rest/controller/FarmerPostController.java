package main.agromarket.farmer.infrastructure.rest.controller;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import main.agromarket.farmer.application.create.CreateFarmerRequest;
import main.agromarket.farmer.application.create.CreateFarmerUseCase;
import main.agromarket.farmer.domain.ports.out.response.FarmerResponseDto;
import main.agromarket.shared.Enum.Status;
import main.agromarket.shared.exception.GeneralException;
import org.hibernate.validator.constraints.Length;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public final class FarmerPostController {
    private CreateFarmerUseCase creator;
    public FarmerPostController(CreateFarmerUseCase creator) {
        this.creator = creator;
    }
    @PostMapping("farmer/create")
    public ResponseEntity<FarmerResponseDto> create(@Valid @RequestBody Request request, BindingResult errorResult){
        if(errorResult.hasErrors()){
            String errorMessage = GeneralException.extractErrorMessage(errorResult);
            throw new GeneralException(errorMessage, HttpStatus.BAD_REQUEST);
        }
        List<CreateFarmerRequest.ContactInfo> companyContacts = request.contact.stream()
                .map(contactDetail -> new CreateFarmerRequest.ContactInfo(
                        contactDetail.contactType(),
                        contactDetail.contact()
                )).toList();
        List<CreateFarmerRequest.FarmType> farmTypes = request.type.stream()
                        .map(typeFarmInfo -> new CreateFarmerRequest.FarmType(
                                typeFarmInfo.typeFarm,
                                typeFarmInfo.farm
                        )).toList();
        FarmerResponseDto result = creator.createFarmer(new CreateFarmerRequest(request.userName, request.email,
                request.password, request.lastName, request.address, companyContacts, farmTypes, Status.FARMER));
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
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

        @Valid
        private List<typeFarmInfo> type;

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

        public List<typeFarmInfo> type() {
            return type;
        }

        public void setStatus(Status status){this.status = status;}
        public void setContact(List<ContactDetail> contact) {
            this.contact = contact;
        }

        public void setType(List<typeFarmInfo> type) {
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
        final static class typeFarmInfo{
            @NotBlank(message = "El tipo de granja no puede estar vacío.")
            @Size(min = 3, max = 50, message = "El tipo de granja debe tener entre 3 y 50 caracteres.")
            private String typeFarm;

            @NotBlank(message = "El nombre de la granja no puede estar vacío.")
            @Size(min = 3, max = 50, message = "El nombre de la granja debe tener entre 3 y 50 caracteres.")
            private String farm;

            public String typeFarm() {
                return typeFarm;
            }

            public void setTypeFarm(String typeFarm) {
                this.typeFarm = typeFarm;
            }

            public String farm() {
                return farm;
            }

            public void setFarm(String farm) {
                this.farm = farm;
            }
        }
    }
}