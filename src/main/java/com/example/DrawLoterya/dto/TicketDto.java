package com.example.DrawLoterya.dto;

import com.example.DrawLoterya.model.User;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

public class TicketDto {
    private Integer id;
    private String name;
    private Integer price;
    private String description;
    private String userEmail;

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Integer getPrice() {
        return price;
    }
    public void setPrice(Integer price) {
        this.price = price;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public String getUserEmail() {
        return userEmail;
    }
    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }
    @Override
    public String toString() {
        return "TicketDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", description='" + description + '\'' +
                ", userEmail='" + userEmail + '\'' +
                '}';
    }
}
