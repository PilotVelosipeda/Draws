package com.example.DrawLoterya.services;

import com.example.DrawLoterya.dto.TicketDto;
import com.example.DrawLoterya.dto.UserDto;
import com.example.DrawLoterya.model.User;
import com.example.DrawLoterya.model.Ticket;
import com.example.DrawLoterya.repositories.UserRepository;
import jdk.jshell.spi.ExecutionControl;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserCRUDService implements UserService<UserDto> {
    private final UserRepository userRepository;

    public UserCRUDService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void create(UserDto userDto) {
        User user = mapToEntity(userDto);
        System.out.println("\nUser dto service: " + user +"\n");
        userRepository.save(user);
    }
    public static UserDto mapToDto(User user) {
        UserDto userDto = new UserDto();
        userDto.setEmail(user.getEmail());
        userDto.setPhoto(user.getPhoto());
        userDto.setPassword(user.getPassword());
        userDto.setFullName(user.getFullName());
        userDto.setBirthdayUser(user.getBirthdayUser());
        userDto.setPhoneNumberUser(user.getPhoneNumberUser());
        userDto.setTelegram(user.getTelegram());
        userDto.setVk(user.getVk());
        userDto.setTickets(
                user.getTickets()
                        .stream()
                        .map(TicketCRUDService::mapToDto)
                        .toList());
        return userDto;
    }

    public static User mapToEntity(UserDto userDto) {
        User user = new User();
        user.setId(userDto.getId());
        user.setEmail(userDto.getEmail());
        user.setPhoto(userDto.getPhoto());
        user.setPassword(userDto.getPassword());
        user.setFullName(userDto.getFullName());
        user.setBirthdayUser(userDto.getBirthdayUser());
        user.setPhoneNumberUser(userDto.getPhoneNumberUser());
        user.setTelegram(userDto.getTelegram());
        user.setVk(userDto.getVk());
        System.out.println("\nUser in service in mapToEntity: " + user +"\n");

        if (userDto.getTickets() == null && user.getTickets() == null) {
            userDto.ticketsDto = new ArrayList<>();
        }

        user.setTickets(
                userDto.getTickets()
                        .stream()
                        .map(TicketCRUDService::mapToEntity)
                        .toList());
        return user;
    }

    @Override
    public void update(UserDto userDto) {
    }
    @Override
    public String get(String key) {
        return null;
    }
}
