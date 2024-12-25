package com.vaibhavcodes.jobportal.controller;

import com.vaibhavcodes.jobportal.entity.Users;
import com.vaibhavcodes.jobportal.entity.UsersType;
import com.vaibhavcodes.jobportal.service.UserTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class UserController {


    @Autowired
    UserTypeService userTypeService;

    @GetMapping("/register")
    public String register(Model modal){
        List<UsersType> allUserType = userTypeService.getAll();
        modal.addAttribute("getAllTypes",allUserType);
        modal.addAttribute("user",new Users());
        return "register";
    }
}
