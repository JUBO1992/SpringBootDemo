package com.jubo.springboot01.practice.service;

import org.springframework.stereotype.Service;

/**
 * @author JUBO
 * @version 1.0.0
 * @date 2021/02/23
 */
@Service
public class MainService {
    public int add(int a, int b) {
        return a + b;
    }
}
