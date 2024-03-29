package main.agromarket.users.application.dto;

import jakarta.persistence.Column;

import java.util.Objects;

public class CreateUserRequest {

    private Long userId;
    private String userName;
    private String email;
    private String password;
    private Long status;

    public CreateUserRequest(Long userId, String userName, String email, String password, Long status) {
        this.userId = userId;
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.status = status;
    }

    public Long userId() {
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

    public Long status() {
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
