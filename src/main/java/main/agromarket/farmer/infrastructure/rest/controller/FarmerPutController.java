package main.agromarket.farmer.infrastructure.rest.controller;

import main.agromarket.farmer.application.create.CreateFarmerRequest;
import main.agromarket.farmer.application.create.CreateFarmerUseCase;
import main.agromarket.shared.Enum.Status;
import main.agromarket.shared.exception.FarmerException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public final class FarmerPutController {
    private CreateFarmerUseCase creator;
    public FarmerPutController(CreateFarmerUseCase creator) {
        this.creator = creator;
    }
    @PutMapping(value = "/user/{id}")
    public ResponseEntity<String> create(@PathVariable String id, @RequestBody Request request){
        try {
            creator.createFarmer(new CreateFarmerRequest(id, request.userName, request.email,
                    request.password, request.lastName, request.address, request.contact, request.type, Status.FARMER));
            return new ResponseEntity<>(HttpStatus.CREATED);
        }catch (FarmerException e){
            return new ResponseEntity<>(e.getErrorMessage(), e.getErrorCode());
        }
    }
    final static class Request {
        private String userName;
        private String email;
        private String password;
        private String lastName;
        private String address;
        private String contact;
        private String type;

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

        public String contact() {
            return contact;
        }

        public String type() {
            return type;
        }


        public void setContact(String contact) {
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
    }
}