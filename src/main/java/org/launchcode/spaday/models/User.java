package org.launchcode.spaday.models;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Null;
import javax.validation.constraints.Size;

public class User {
    @NotBlank(message="username is required")
    @Size(min=5, max=15)
    private String username;

    @Email
    private String email;

    @NotBlank(message="password is required")
    @Size(min=6, message="mininmum password length is 6 characters")
    private String password;

    private String verify;

    @Null(message="passwords do not match")
    @Size(min=6, message="mininmum password length is 6 characters")
    private String verifyPassword;

    public User() {

    }

    public User(String username, String email, String password, String verifyPassword) {
        this();
        this.username = username;
        this.email = email;
        this.password = password;
        this.verifyPassword = verifyPassword;
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
//        checkPassword();

    }

    public String getVerifyPassword() {
        return verifyPassword;
    }

    public void setVerifyPassword(String verifyPassword) {
        this.verifyPassword = verifyPassword;
        checkPassword();

    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    private void checkPassword() {
        if (!this.password.isEmpty()
                && (this.getVerifyPassword() != null)
                && (!this.password.equals(this.verifyPassword))) {
            verifyPassword = null;
        }

    }
}
