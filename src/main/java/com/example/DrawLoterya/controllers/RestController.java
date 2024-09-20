package com.example.DrawLoterya.controllers;

import com.example.DrawLoterya.dto.UserDto;
import com.example.DrawLoterya.services.UserCRUDService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@org.springframework.web.bind.annotation.RestController
public class RestController {
    public final UserCRUDService userCRUDService;

    public RestController(UserCRUDService userCRUDService) {
        this.userCRUDService = userCRUDService;
    }

    @PostMapping("/addUser/")
    public void createUser(UserDto userDto) {
        System.out.println("User dto - " + userDto);
        userCRUDService.create(userDto);
    }
    @PostMapping("/updateInformationUser/")
    public void updateInformationUser(@RequestParam("fioUser") String fioUser, @RequestParam("birthday") String birthday,
                                      @RequestParam("updateEmail") String email, @RequestParam("phone") String phoneUser,
                                      @RequestParam("telegram") String telegram, @RequestParam("vk") String vk) throws Exception {
        userCRUDService.update(fioUser, birthday, email, phoneUser, telegram, vk);
    }

    //alter table user modify column photo longblob
    @PostMapping("/addImage/")
    public void addImage(@RequestParam("file") MultipartFile image) throws IOException {
        userCRUDService.loadImage(image);
    }
}
