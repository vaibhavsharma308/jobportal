package com.vaibhavcodes.jobportal.controller;

import com.vaibhavcodes.jobportal.entity.Users;
import com.vaibhavcodes.jobportal.entity.UsersType;
import com.vaibhavcodes.jobportal.service.UserService;
import com.vaibhavcodes.jobportal.service.UserTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class UserController {


    @Autowired
    UserTypeService userTypeService;
    @Autowired
    UserService userService;
    @GetMapping("/register")
    public String register(Model modal){
        List<UsersType> allUserType = userTypeService.getAll();
        modal.addAttribute("getAllTypes",allUserType);
        modal.addAttribute("user",new Users());
        return "register";
    }
    @PostMapping("register/new")
    public String userRegistration(Users user,Model modal){
        Boolean isPresent=userService.getUserByEmail(user);
        if(isPresent.equals(true)){
            modal.addAttribute("error","Duplicate Email please enter new email address");
            List<UsersType> allUserType = userTypeService.getAll();
            modal.addAttribute("getAllTypes",allUserType);
            modal.addAttribute("user",new Users());
            return "register";
        }
        userService.userRegistration(user);
        return "dashboard";
    }
}
