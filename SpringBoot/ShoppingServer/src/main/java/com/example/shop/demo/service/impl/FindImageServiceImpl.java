package com.example.shop.demo.service.impl;

import com.example.shop.demo.entity.Image;
import com.example.shop.demo.repository.ImageRepository;
import com.example.shop.demo.service.FindImageService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;

@Service
public class FindImageServiceImpl implements FindImageService {

    @Resource
    private ImageRepository imageRepository;


    @Override
    public List<Image> findAll() {
        return imageRepository.findAll();
    }
}
