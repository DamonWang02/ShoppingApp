package com.example.shop.demo.controller;

import com.example.shop.demo.entity.SaveList;
import com.example.shop.demo.service.SaveListService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
public class SaveListController {

    @Resource
    SaveListService saveListService;

    @GetMapping("/savelistentity")
    public SaveList saveCommodity(SaveList saveList){

        SaveList saveListEntity = saveListService.saveListEntity(saveList);
        return saveListEntity;
    }

    @PostMapping("/savelistentity")
    public SaveList saveCommodityWithPost(SaveList saveList){

        SaveList saveListEntity = saveListService.saveListEntity(saveList);
        return saveListEntity;
    }


}
