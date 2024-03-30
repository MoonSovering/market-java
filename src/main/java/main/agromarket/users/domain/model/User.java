package main.agromarket.users.domain.model;


import java.util.Objects;
import java.util.UUID;

public final class User {
    private UserId user;
    private UserName name;
    private UserEmail email;
    private UserPassword password;
    private UserStatus status;
    public User(UserId user, UserName name, UserEmail email, UserPassword password, UserStatus status) {
        this.user = user;
        this.name = name;
        this.email = email;
        this.password = password;
        this.status = status;
    }

    public UserId getUserId() {
        return user;
    }

    public UserName getUserName() {
        return name;
    }

    public UserEmail getEmail() {
        return email;
    }
    public UserPassword getPassword() {
        return password;
    }

    public UserStatus getStatus() {
        return status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (!Objects.equals(user, user.user)) return false;
        if (!Objects.equals(name, user.name)) return false;
        if (!Objects.equals(email, user.email)) return false;
        if (!Objects.equals(password, user.password)) return false;
        return Objects.equals(status, user.status);
    }

    @Override
    public int hashCode() {
        int result = user != null ? user.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        return result;
    }
}
