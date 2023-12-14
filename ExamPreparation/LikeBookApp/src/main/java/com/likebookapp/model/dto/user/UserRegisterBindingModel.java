package com.likebookapp.model.dto.user;

import com.likebookapp.validations.FieldMatch;
import com.likebookapp.validations.UniqueEmail;
import com.likebookapp.validations.UniqueUsername;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@FieldMatch(first = "password", second = "confirmPassword", message = "Passwords do not match.")
public class UserRegisterBindingModel {

    @NotBlank(message = "Username cannot be empty")
    @Size(min = 3, max = 20, message = "Username length must be between 3 and 20 characters.")
    @UniqueUsername
    private String username;

    @NotBlank(message = "Email cannot be empty")
    @Email(message = "Provide valid email")
    @UniqueEmail
    private String email;

    @NotBlank(message = "Password cannot be empty")
    @Size(min = 3, max = 20, message = "Password length must be between 3 and 20 characters.")
    private String password;

    @NotBlank(message = "Confirm Password cannot be empty")
    @Size(min = 3, max = 20, message = "Password length must be between 3 and 20 characters.")
    private String confirmPassword;

    public UserRegisterBindingModel() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }
}