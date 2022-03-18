package com.mongo.spring.controller;

import com.mongo.spring.model.Price;
import com.mongo.spring.repository.PriceRepository;
import com.mongo.spring.service.PriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@RestController
public class PriceController {


    @Autowired
    private PriceService priceService;


    @GetMapping("/all/{name}")
    public List<Price> findAll(@PathVariable String name) {
       return  priceService.findAll(name);
    }

    @GetMapping("/cryptocurrenci/minprice/{name}")
    public Object minPrice(@PathVariable String name) {
        return  priceService.minPrice(name);
    }


    @GetMapping("/cryptocurrenci/maxprice/{name}")
    public Object maxPrice(@PathVariable String name) {
        return  priceService.maxPrice(name);
    }

    @GetMapping("/cryptocurrencies/page/size")
    public List<Price> sort(){
        return  priceService.sort();
    }
}



