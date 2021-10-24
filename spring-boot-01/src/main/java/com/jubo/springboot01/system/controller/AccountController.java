package com.jubo.springboot01.system.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jubo.springboot01.common.utils.RespStat;
import com.jubo.springboot01.config.ProjectConfig;
import com.jubo.springboot01.system.bean.Account;
import com.jubo.springboot01.system.bean.Permission;
import com.jubo.springboot01.system.bean.Role;
import com.jubo.springboot01.system.service.impl.AccountServiceImpl;
import com.jubo.springboot01.system.service.impl.PermissionServiceImpl;
import com.jubo.springboot01.system.service.impl.RoleServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;

/**
 * <p>
 * 前端控制器
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

    @Autowired
    AccountServiceImpl accountService;

    @Autowired
    PermissionServiceImpl permissionService;

    @Autowired
    RoleServiceImpl roleService;

    @RequestMapping("/login")
    public String login(Model model) {
        model.addAttribute("projectConfig", projectConfig);
        return "account/login";
    }

    @RequestMapping("/validateAccount")
    @ResponseBody
    public String validateAccount(String loginName, String password, HttpServletRequest request) {

        // 1. 直接返回是否登录成功的结果
        // 2. 返回 Account对象，对象是空的 ，在controller里做业务逻辑
        // 在公司里 统一写法

        //让service返回对象，如果登录成功 把用户的对象
        Account account = accountService.findByLoginNameAndPassword(loginName, password);

        if (account == null) {
            return "登录失败";
        } else {
            // 登录成功
            // 写到Session里
            // 在不同的controller 或者前端页面上 都能使用
            // 当前登录用户的Account对象

            request.getSession().setAttribute("account", account);
            return "success";
        }
    }

    @RequestMapping("/logout")
    public String logout(HttpServletRequest request) {
        request.getSession().removeAttribute("account");
        return "account/login";
    }

    @RequestMapping("/list")
    public String list(@RequestParam(defaultValue = "1") int pageNum, @RequestParam(defaultValue = "5") int pageSize, Model model) {
        Page<Account> page = accountService.findByPage(pageNum, pageSize);
        model.addAttribute("page", page);
        return "account/list";
    }

    @RequestMapping("/deleteById")
    @ResponseBody
    public RespStat deleteById(int id) {
        RespStat stat = accountService.deleteById(id);
        return stat;
    }

    @RequestMapping("/profile")
    public String profile() {
        return "account/profile";
    }

    @RequestMapping("/fileUpload")
    public String fileUpload(MultipartFile filename, String password, HttpServletRequest request) {
        Account account = (Account) request.getSession().getAttribute("account");

        try {
            String uploadPath = projectConfig.getUploadPath();
            filename.transferTo(new File(uploadPath + "/" + filename.getOriginalFilename()));
            account.setLocation(filename.getOriginalFilename());
            accountService.update(account);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "account/profile";
    }

    @RequestMapping("/accountList")
    public String accountList(@RequestParam(defaultValue = "1") int pageNum, @RequestParam(defaultValue = "5") int pageSize, Model model) {
        Page<Account> accountPage = accountService.findByPage(pageNum, pageSize);
        model.addAttribute("accountPage", accountPage);
        return "account/accountList";
    }

    @RequestMapping("/permissionList")
    public String permissionList(@RequestParam(defaultValue = "1") int pageNum, @RequestParam(defaultValue = "5") int pageSize, Model model) {
        Page<Permission> permissionPage = permissionService.findByPage(pageNum, pageSize);
        model.addAttribute("permissionPage", permissionPage);
        return "account/permissionList";
    }

    @RequestMapping("/roleList")
    public String roleList(@RequestParam(defaultValue = "1") int pageNum, @RequestParam(defaultValue = "5") int pageSize, Model model) {
        Page<Role> rolePage = roleService.findByPage(pageNum, pageSize);
        model.addAttribute("rolePage", rolePage);
        return "account/roleList";
    }

    @RequestMapping("/permissionModify")
    public String permissionModify(@RequestParam int id, Model model) {
        Permission permission = permissionService.getById(id);
        model.addAttribute("p", permission);
        return "account/permissionModify";
    }
}

