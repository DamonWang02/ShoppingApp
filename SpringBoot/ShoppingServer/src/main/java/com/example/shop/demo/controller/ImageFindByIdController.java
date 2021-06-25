package com.example.shop.demo.controller;

import com.example.shop.demo.entity.Image;
import com.example.shop.demo.entity.User;
import com.example.shop.demo.service.FindImageService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@RestController
public class ImageFindByIdController {

    @Resource
    FindImageService findImageService;

    @GetMapping("/findImage")
    public List<Image> selectImageAllWithGet(Image image) {

        return findImageService.findAll();
    }

    @PostMapping("/findImage")
    public List<Image> selectImageAll(Image image) {

        return findImageService.findAll();
    }
}
