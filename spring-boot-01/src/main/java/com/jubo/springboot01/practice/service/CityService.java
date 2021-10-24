package com.jubo.springboot01.practice.service;

import com.jubo.springboot01.practice.bean.City;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @author JUBO
 * @version 1.0.0
 * @date 2021/02/25
 */
@Service
public class CityService {
    public List<City> findAll() {
        List<City> list = new LinkedList<>();
        return list;
    }

    public String add(City city) {
        return "success";
    }
}
