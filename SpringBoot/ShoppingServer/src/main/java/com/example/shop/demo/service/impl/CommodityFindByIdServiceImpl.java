package com.example.shop.demo.service.impl;

import com.example.shop.demo.entity.Commodity;
import com.example.shop.demo.repository.CommodityRepository;
import com.example.shop.demo.service.CommodityFindByIdService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Optional;

@Service
public class CommodityFindByIdServiceImpl implements CommodityFindByIdService {

    @Resource
    private CommodityRepository commodityRepository;


    @Override
    public Optional<Commodity> findById(Integer id) {
        return commodityRepository.findById(id);
    }
}
