package com.example.shop.demo.repository;

import com.example.shop.demo.entity.SaveList;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SaveListRepository extends JpaRepository<SaveList,String> {

    public List<SaveList> findAll();


}

