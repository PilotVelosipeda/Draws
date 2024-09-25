package com.example.DrawLoterya.services;

import com.example.DrawLoterya.dto.TicketDto;
import com.example.DrawLoterya.dto.UserDto;
import com.example.DrawLoterya.model.Ticket;
import com.example.DrawLoterya.model.User;
import com.example.DrawLoterya.repositories.UserRepository;
import jdk.jshell.spi.ExecutionControl;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;

@Service
public class UserCRUDService implements UserService<UserDto> {
    private User currentUser;
    private final UserRepository userRepository;

    public UserCRUDService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void create(UserDto userDto) {
        User user = mapToEntity(userDto);
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
//        userDto.setTickets(
//                user.getTickets()
//                        .stream()
//                        .map(TicketCRUDService::mapToDto)
//                        .toList());
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

        if (userDto.getTickets() ==  null) {
            System.out.println("userDto.getTickets() ==  null");
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
    public void update(String fioUser, String birthday,
                       String email, String phoneUser,
                       String telegram, String vk) {
        User user = userRepository.findByEmail(email);
        user.setFullName(fioUser);
        user.setBirthdayUser(birthday);
        user.setPhoneNumberUser(phoneUser);
        user.setEmail(email);
        user.setTelegram(telegram);
        user.setVk(vk);
        currentUser = user;
        userRepository.save(user);
    }

    @Override
    public ResponseEntity<byte[]> updateImage(String email) {
        User user = userRepository.findById(email).get();
        return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(user.getPhoto());
    }

    @Override
    public void loadImage(MultipartFile image) throws IOException {
        User user = userRepository.findByEmail(currentUser.getEmail());
        user.setPhoto(image.getBytes());
        userRepository.save(user);
    }

    @Override
    public String get(String email, Model model) {
        User user = userRepository.findByEmail(email);
        model.addAttribute("userId", user.getId());
        model.addAttribute("photo", user.getPhoto());
        model.addAttribute("fioUser", user.getFullName());
        model.addAttribute("birthday", user.getBirthdayUser());
        model.addAttribute("updateEmail", user.getEmail());
        model.addAttribute("phoneUser", user.getPhoneNumberUser());
        model.addAttribute("telegram", user.getTelegram());
        model.addAttribute("vk", user.getVk());
        return "pageUser";
    }
}
