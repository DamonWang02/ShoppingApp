package com.example.shop.demo.service.impl;

import com.example.shop.demo.entity.Commodity;
import com.example.shop.demo.entity.SaveList;
import com.example.shop.demo.repository.SaveListRepository;
import com.example.shop.demo.service.SaveListService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class SaveListServiceImpl implements SaveListService {

    @Resource
    private SaveListRepository saveListRepository;


    @Override
    public List<SaveList> findAll() {
        return saveListRepository.findAll();
    }

    @Override
    public SaveList saveListEntity(SaveList saveList) {
        return saveListRepository.save(saveList);
    }
}
