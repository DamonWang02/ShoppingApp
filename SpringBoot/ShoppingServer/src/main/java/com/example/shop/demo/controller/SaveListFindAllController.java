package com.example.shop.demo.controller;

import com.example.shop.demo.entity.SaveList;
import com.example.shop.demo.entity.User;
import com.example.shop.demo.service.SaveListService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class SaveListFindAllController {

    @Resource
    private SaveListService saveListService;

    @GetMapping(value = "/findallsavelist")
    public List<SaveList> insertSaveList(SaveList saveList) {
        return  saveListService.findAll();

    }

    @PostMapping(value = "/findallsavelist")
    public List<SaveList> insertSaveListWithPost(SaveList saveList) {
        return  saveListService.findAll();
    }
}
