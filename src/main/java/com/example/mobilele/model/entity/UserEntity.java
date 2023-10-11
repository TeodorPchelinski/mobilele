package com.example.mobilele.model.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class UserEntity extends BasedEntity{



    private String firstName;

    private String lastName;

    @Column(unique = true)
    private String email;

    private String password;
    private boolean active;

    public String getPassword() {
        return password;
    }

    public UserEntity setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }


    public UserEntity setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public UserEntity setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }


    public String getEmail() {
        return email;
    }

    public UserEntity setEmail(String email) {
        this.email = email;
        return this;
    }

    public boolean isActive() {
        return active;
    }

    public UserEntity setActive(boolean active) {
        this.active = active;
        return this;
    }

}
