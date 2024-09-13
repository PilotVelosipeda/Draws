package com.example.DrawLoterya.model;
import jakarta.persistence.*;

import java.util.Arrays;
import java.util.List;

@Entity
@Table(name = "users")
public class User {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Id
    private String email;
    @Lob
    private byte[] photo;
    private String password;
    private String fullName;
    private String birthdayUser;
    private String phoneNumberUser;
    private String vk;
    private String telegram;
    @OneToMany
    public List<Ticket> tickets;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public byte[] getPhoto() {
        return photo;
    }

    public void setPhoto(byte[] photo) {
        this.photo = photo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getBirthdayUser() {
        return birthdayUser;
    }

    public void setBirthdayUser(String birthdayUser) {
        this.birthdayUser = birthdayUser;
    }

    public String getPhoneNumberUser() {
        return phoneNumberUser;
    }

    public void setPhoneNumberUser(String phoneNumberUser) {
        this.phoneNumberUser = phoneNumberUser;
    }

    public String getVk() {
        return vk;
    }

    public void setVk(String vk) {
        this.vk = vk;
    }

    public String getTelegram() {
        return telegram;
    }

    public void setTelegram(String telegram) {
        this.telegram = telegram;
    }


    public List<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(List<Ticket> tickets) {
        this.tickets = tickets;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", photo=" + Arrays.toString(photo) +
                ", password='" + password + '\'' +
                ", fullName='" + fullName + '\'' +
                ", birthdayUser='" + birthdayUser + '\'' +
                ", phoneNumberUser='" + phoneNumberUser + '\'' +
                ", vk='" + vk + '\'' +
                ", telegram='" + telegram + '\'' +
                ", tickets=" + tickets +
                '}';
    }
}
