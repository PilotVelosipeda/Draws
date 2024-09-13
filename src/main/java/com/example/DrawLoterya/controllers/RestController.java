package com.example.DrawLoterya.controllers;

import com.example.DrawLoterya.dto.UserDto;
import com.example.DrawLoterya.services.UserCRUDService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@org.springframework.web.bind.annotation.RestController
public class RestController {
    public final UserCRUDService userCRUDService;

    public RestController(UserCRUDService userCRUDService) {
        this.userCRUDService = userCRUDService;
    }
    @PostMapping("/addUser/")
    public void createUser(UserDto userDto) {
        System.out.println("\nUser  dto - " + userDto + "\n");
        userCRUDService.create(userDto);
    }

}
