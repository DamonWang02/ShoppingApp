package com.example.shop.demo.service.impl;

import com.example.shop.demo.entity.Commodity;
import com.example.shop.demo.entity.SaveList;
import com.example.shop.demo.repository.CommodityRepository;
import com.example.shop.demo.service.CommodityFindService;
import com.example.shop.demo.service.SaveListService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CommodityFindServiceImpl implements CommodityFindService {

    @Resource
    private CommodityRepository commodityRepository;


    @Override
    public List<Commodity> findAll() {
        return commodityRepository.findAll();
    }


}
