package com.example.shop.demo.service;

import com.example.shop.demo.entity.Commodity;

import java.util.Optional;

public interface CommodityFindByIdService {

    Optional<Commodity> findById(Integer id);
}
