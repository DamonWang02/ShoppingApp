package com.example.shop.demo.repository;

import com.example.shop.demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, String> {

    List<User> findByPhone(String phone);
}
