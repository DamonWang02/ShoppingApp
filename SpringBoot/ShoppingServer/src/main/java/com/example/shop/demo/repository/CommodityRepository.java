package com.example.shop.demo.repository;

import com.example.shop.demo.entity.Commodity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CommodityRepository extends JpaRepository<Commodity, Integer> {

    Optional<Commodity> findById(Integer id);

}
