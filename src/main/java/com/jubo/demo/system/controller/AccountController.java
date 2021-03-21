package com.jubo.demo.system.controller;


import com.jubo.demo.config.ProjectConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author jubo
 * @since 2021-03-21
 */
@Controller
@RequestMapping("/account")
public class AccountController {

    @Autowired
    ProjectConfig projectConfig;

    @RequestMapping("/login")
    public String login(Model model) {
        model.addAttribute("projectConfig", projectConfig);
        return "/account/login";
    }
}

