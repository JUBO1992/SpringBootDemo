package com.jubo.springboot01.practice.controller;

import com.jubo.springboot01.practice.bean.City;
import com.jubo.springboot01.practice.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @author JUBO
 * @version 1.0.0
 * @date 2021/02/25
 * 在我们访问 http://主机名:端口号/context-path/Controller的URI/方法的URI
 * http://localhost:8080/list
 * @Controller 加入Spring容器管理，单例
 */
@Controller
public class CityController {
    @Autowired
    CityService cityService;

    @RequestMapping("/list")
    public String list(Model map) {
        List<City> list = cityService.findAll();
        map.addAttribute("list", list);
        return "list";
    }

    @RequestMapping("/addCity")
    public String addCity(@ModelAttribute City city, Model map) {
        System.out.println(city);
        String success = cityService.add(city);
        map.addAttribute("success", success);
        return "addCity";
    }

    @RequestMapping("/addPage")
    public String addPage() {
        return "addPage";
    }

}
