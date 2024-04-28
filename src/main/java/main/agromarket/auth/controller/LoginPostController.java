package main.agromarket.auth.controller;

import jakarta.validation.Valid;
import main.agromarket.auth.dtos.LoginUserDto;
import main.agromarket.auth.service.LoginUserUseCase;
import main.agromarket.shared.exception.GeneralException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginPostController {
    private final LoginUserUseCase login;

    public LoginPostController(LoginUserUseCase login) {
        this.login = login;
    }
    @PostMapping("auth/sign-in")
    public ResponseEntity<?> loginClient(@Valid @RequestBody LoginUserDto body, BindingResult errorResult){
        if(errorResult.hasErrors()){
            String errorMessage = GeneralException.extractErrorMessage(errorResult);
            throw new GeneralException(errorMessage, HttpStatus.BAD_REQUEST);
        }
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(login.loginUser(body));
    }
}
