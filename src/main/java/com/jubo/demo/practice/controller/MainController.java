package com.jubo.demo.practice.controller;

import com.jubo.demo.practice.service.MainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * @author JUBO
 * @version 1.0.0
 * @date 2021/02/23
 *
 * 在我们访问 http://主机名:端口号/context-path/Controller的URI/方法的URI
 * http://localhost:8080/add
 * @Controller 加入Spring容器管理，单例
 */
@Controller
public class MainController {

    @Autowired
    MainService mySrv;

    /**
     * 地址栏调用方式：http://localhost:8080/add?a=1&b=2
     * @param a
     * @param b
     * @return
     */
    @GetMapping("/add")
    @ResponseBody
    public int add(int a, int b) {
        return mySrv.add(a, b);
    }

    @RequestMapping("/hello")
    public String test(Model model) {
        System.out.println("hello");
        model.addAttribute("msg", "haha jubo");
        return "practice/hello";
    }

    @RequestMapping("/login")
    public String login() {
        return "practice/login";
    }

    @RequestMapping("/index")
    public String index() {
        return "index";
    }
}