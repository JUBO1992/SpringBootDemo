package com.jubo.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author JUBO
 * @version 1.0.0
 * @date 2021/02/23
 */
@RestController
public class MainController {

    @Autowired
    MyService mySrv;

    @GetMapping("/add")
    public int add(int a, int b) {
        return mySrv.add(a, b);
    }

}