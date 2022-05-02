package org.aibles.spring.javer.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Table(name = "USER_INFO")
@Entity
public class UserEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;

    @Column(name = "USERNAME", unique = true, nullable = false, length = 50)
    private String username;

    @Column(name = "EMAIL", unique = true, nullable = false, length = 256)
    private String email;

    @Column(name = "PHONE_NUMBER", length = 15)
    private String phoneNumber;

    @Column(name = "PASSWORD", length = 256, nullable = false)
    private String password;

    @Column(name = "ADDRESS", length = 256)
    private String address;

    public UserEntity() {
    }

    /**
     * UserEntity constructor full args
     * @param id - id
     * @param username - username
     * @param email - email
     * @param phoneNumber - phone number
     * @param password - password
     * @param address - address
     */
    public UserEntity(Integer id, String username, String email, String phoneNumber, String password, String address) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.password = password;
        this.address = address;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserEntity)) return false;
        UserEntity user = (UserEntity) o;
        return getId().equals(user.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
