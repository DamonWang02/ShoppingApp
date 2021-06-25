package com.example.shop.demo.controller;

import com.example.shop.demo.entity.User;
import com.example.shop.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SaveUser {

    @Autowired
    UserRepository userRepository;

    @GetMapping(value = "/saveuser")
    public User insertUser(User user) {
        User save = userRepository.save(user);
        return save;
    }

    @PostMapping(value = "/saveuser")
    public User insertUserWithPost(User user) {
        User save = userRepository.save(user);
        return save;
    }
}
