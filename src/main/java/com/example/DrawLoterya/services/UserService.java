package com.example.DrawLoterya.services;

import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface UserService<T> {
    void create(T t);
    void update(String fioUser, String birthday,
                String email, String phoneUser,
                String telegram, String vk);
    ResponseEntity<byte[]> updateImage(String email);
    void loadImage(MultipartFile image) throws IOException;
    String get(String email, Model model);
}
