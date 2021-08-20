package edu.eci.users.dto;

import java.util.Date;

public class UserDTO {

    private String name;
    private String email;
    private String lastName;
    private Date createdAt;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "UserDTO [createdAt=" + createdAt + ", email=" + email + ", lastName=" + lastName + ", name=" + name
                + "]";
    }

    

}
