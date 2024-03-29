package main.agromarket.users.infrastructure.controller;

import main.agromarket.users.application.dto.CreateUserRequest;
import main.agromarket.users.application.usecases.CreateUserUseCase;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public final class UserPutController {
    private CreateUserUseCase creator;
    public UserPutController(CreateUserUseCase creator) {
        this.creator = creator;
    }
    @PutMapping(value = "/user/{id}")
    public ResponseEntity<String> create(@PathVariable Long id, @RequestBody Request request){
        creator.createUser(new CreateUserRequest(id, request.userName, request.email, request.password, request.status));
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    final static class Request {
        private String userName;
        private String email;
        private String password;
        private Long status;

        public String userName() {
            return userName;
        }

        public String email() {
            return email;
        }

        public String password() {
            return password;
        }

        public Long status() {
            return status;
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

        public void setStatus(Long status) {
            this.status = status;
        }
    }
}