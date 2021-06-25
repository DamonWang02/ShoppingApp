package com.example.shop.demo.controller;


import com.example.shop.demo.entity.User;
import com.example.shop.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SelectUser {

    @Autowired
    UserRepository userRepository;

    @GetMapping("/selectuser/{phone}")
    public List<User> getUser(@PathVariable("phone") String phone) {

        List<User> userlist = userRepository.findByPhone(phone);
        return userlist;

    }

    @PostMapping("/selectuser/{phone}")
    public List<User> postUser(@PathVariable("phone") String phone) {

        List<User> userlist = userRepository.findByPhone(phone);

        return userlist;

    }
}
