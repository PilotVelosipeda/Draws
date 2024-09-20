package com.example.DrawLoterya.controllers;

import com.example.DrawLoterya.services.UserCRUDService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DefaultController {
    public final UserCRUDService userCRUDService;
    public DefaultController(UserCRUDService userCRUDService) {this.userCRUDService = userCRUDService;
    }
    @GetMapping("/")
    public String getMainPage() {
        return "mainPage";
    }

    @GetMapping("/pageCurrentUser")
    public String pageCurrentUser(@RequestParam("send_form_form_entrance_user") String email, Model model) {
        return userCRUDService.get(email, model);
    }
}

