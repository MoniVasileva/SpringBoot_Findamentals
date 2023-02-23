package com.softuni.pathfinder.domain.dto.binding;

import jakarta.validation.constraints.*;

public class UserRegisterForm {
  @Size(min = 5, max = 20)
    private String username;
    @Size(min = 5, max = 20)
    private String fullName;
    @Email
    private String email;
    @NotNull
    private String age;
    @Size(min = 5, max = 20)
    private String password;
    private String confirmPassword;
    private String lastName;

    public UserRegisterForm() {
    }

    public String getUsername() {
        return username;
    }

    public UserRegisterForm setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getFullName() {
        return fullName;
    }

    public UserRegisterForm setFullName(String fullName) {
        this.fullName = fullName;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public UserRegisterForm setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getAge() {
        return age;
    }

    public UserRegisterForm setAge(String age) {
        this.age = age;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserRegisterForm setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public UserRegisterForm setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public UserRegisterForm setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }
}
