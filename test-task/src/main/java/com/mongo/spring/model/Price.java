package com.mongo.spring.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import lombok.Data;


@AllArgsConstructor

@NoArgsConstructor
@Data

public class Price implements  Comparable<Price>{




    private Long createdAt;
    private  Double lprice;
    private  String curr1;
    private  String curr2;

    @Override
    public int compareTo(Price o) {
        return this.lprice.compareTo(o.getLprice());
    }

    @Override
    public String toString() {
        return "Price{" +
                "createdAt=" + createdAt +
                ", lprice=" + lprice +
                ", curr1='" + curr1 + '\'' +
                ", curr2='" + curr2 + '\'' +
                '}';
    }
}