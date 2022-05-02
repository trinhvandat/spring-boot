package org.aibles.spring.javer.dto.request;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;

public class UserRegisteringReq {
    @NotBlank(message = "Username is required.")
    @Length(max = 50)
    private String username;

    @NotBlank(message = "Email is required.")
    @Length(max = 256)
    private String email;

    @Length(max = 15)
    private String phoneNumber;

    @NotBlank(message = "Password is required.")
    private String password;

    @Length(max = 256)
    private String address;

    public UserRegisteringReq() {
    }

    /**
     * UserRegisteringReq constructor full args
     * @param username - username
     * @param email - email
     * @param phoneNumber - phone number
     * @param password - password
     * @param address - address
     */
    public UserRegisteringReq(String username, String email, String phoneNumber, String password, String address) {
        this.username = username;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.password = password;
        this.address = address;
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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
