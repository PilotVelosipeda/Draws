package com.example.DrawLoterya.dto;

import com.example.DrawLoterya.model.Ticket;

import java.util.Arrays;
import java.util.List;

public class UserDto {
    private Integer id;
    private String email;
    private byte[] photo;
    private String password;
    private String fullName;
    private String birthdayUser;
    private String phoneNumberUser;
    private String vk;
    private String telegram;
    public List<TicketDto> ticketsDto;
    public List<TicketDto> getTickets() {
        System.out.println("Мы в get.tickets в UserDto");
        return ticketsDto;
    }
    public void setTickets(List<TicketDto> tickets) {
        this.ticketsDto = ticketsDto;
    }

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

    @Override
    public String toString() {
        return "UserDto{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", photo=" + Arrays.toString(photo) +
                ", password='" + password + '\'' +
                ", fullName='" + fullName + '\'' +
                ", birthdayUser='" + birthdayUser + '\'' +
                ", phoneNumberUser='" + phoneNumberUser + '\'' +
                ", vk='" + vk + '\'' +
                ", telegram='" + telegram + '\'' +
                ", tickets=" + ticketsDto +
                '}';
    }
}
