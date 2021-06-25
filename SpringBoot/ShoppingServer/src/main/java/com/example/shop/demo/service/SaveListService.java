package com.example.shop.demo.service;

import com.example.shop.demo.entity.Commodity;
import com.example.shop.demo.entity.SaveList;

import java.util.List;

public interface SaveListService {

    List<SaveList> findAll();

    SaveList saveListEntity(SaveList saveList);
}
