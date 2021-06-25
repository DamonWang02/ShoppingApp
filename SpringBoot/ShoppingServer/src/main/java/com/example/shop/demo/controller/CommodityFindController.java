package com.example.shop.demo.controller;

import com.example.shop.demo.entity.Commodity;
import com.example.shop.demo.service.CommodityFindService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class CommodityFindController {

    @Resource
    private CommodityFindService commodityFindService;

    @GetMapping("/commodityall")
    public List<Commodity> selectCommodityAll(Commodity commodity) {
        return commodityFindService.findAll();
    }

    @PostMapping("/commodityall")
    public List<Commodity> selectCommodityAllWithPost(Commodity commodity) {
        return commodityFindService.findAll();
    }


}
