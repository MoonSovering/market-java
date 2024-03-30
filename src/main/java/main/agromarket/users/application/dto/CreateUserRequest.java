package main.agromarket.users.application.dto;

import jakarta.persistence.Column;

import java.util.Objects;
import java.util.UUID;

public class CreateUserRequest {

    private String userId;
    private String userName;
    private String email;
    private String password;
    private String status;

    public CreateUserRequest(String userId, String userName, String email, String password, String status) {
        this.userId = userId;
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.status = status;
    }

    public String userId() {
        return userId;
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

    public String status() {
        return status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CreateUserRequest that = (CreateUserRequest) o;

        if (!Objects.equals(userId, that.userId)) return false;
        if (!Objects.equals(userName, that.userName)) return false;
        if (!Objects.equals(email, that.email)) return false;
        if (!Objects.equals(password, that.password)) return false;
        return Objects.equals(status, that.status);
    }

    @Override
    public int hashCode() {
        int result = userId != null ? userId.hashCode() : 0;
        result = 31 * result + (userName != null ? userName.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        return result;
    }
}
