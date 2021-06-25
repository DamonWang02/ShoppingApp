package com.example.shop.demo.controller;

import com.example.shop.demo.entity.Commodity;
import com.example.shop.demo.service.CommodityFindByIdService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@RestController
public class CommodityFindByIdController {

    @Resource
    CommodityFindByIdService commodityFindByIdService;

    @GetMapping("/commodityall/{id}")
    public List<Optional> getCommodityById(@PathVariable("id") Integer id) {

        Optional<Commodity> commodityList = commodityFindByIdService.findById(id);

        List<Optional> optionalList = Collections.singletonList(commodityList);
        return optionalList;
    }

    @PostMapping("/commodityall/{id}")
    public List<Optional> getCommodityByIdWithPost(@PathVariable("id") Integer id) {

        Optional<Commodity> commodityList = commodityFindByIdService.findById(id);

        List<Optional> optionalList = Collections.singletonList(commodityList);
        return optionalList;
    }


}
