package com.mongo.spring.service;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mongo.spring.model.Price;
import com.mongo.spring.repository.PriceRepository;
import lombok.AllArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


@Service
@AllArgsConstructor
public class PriceService {

    private PriceRepository repository;


    public List<Price> findAll(String name) {
        List<Price> lists = repository.findAllByCurr1(name);
        if(!lists.isEmpty()){
            return lists;
        }else{
            throw new NullPointerException();
        }
    }


    public Object minPrice(@PathVariable String name) {
        List<Price> list = repository.findAllByCurr1(name);
        if(list.isEmpty()){
            throw new  NullPointerException();
        }
        int i = 1;
        double curent = list.get(i++).getLprice();
        double min = 0;

        for (Price one : list) {

            if (curent > one.getLprice()) {
                min = one.getLprice();
                curent = min;
            }
        }
        return min;
    }



    public Object maxPrice(String name) {
        List<Price> list = repository.findAllByCurr1(name);
        if(list.isEmpty()){
            throw new  NullPointerException();
        }
        int i = 1;
        double curent = list.get(i++).getLprice();
        double max = 0;

        for (Price one : list) {

            if (curent < one.getLprice()) {
                max = one.getLprice();
                curent = max;
            }
        }
        return max;
    }





    public List<Price> sort(){
        List<Price> list = repository.findFirst10By();
        Collections.sort(list);
        return list;


    }

}