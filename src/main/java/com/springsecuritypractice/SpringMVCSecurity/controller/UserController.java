package com.springsecuritypractice.SpringMVCSecurity.controller;

import com.springsecuritypractice.SpringMVCSecurity.dto.UserDto;
import com.springsecuritypractice.SpringMVCSecurity.service.CustomSuccessHandler;
import com.springsecuritypractice.SpringMVCSecurity.service.CustomUserDetail;
import com.springsecuritypractice.SpringMVCSecurity.service.CustomUserDetailService;
import com.springsecuritypractice.SpringMVCSecurity.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private CustomUserDetailService customUserDetailService;



    @GetMapping("/registration")
    public String getRegistrationPage(@ModelAttribute("user")UserDto userDto){

        return "registration";
    }

//    @PostMapping("/registration")
//    public String saveUser(@ModelAttribute("user")UserDto userDto,Model model){
//        userService.save(userDto);
//        model.addAttribute("message","Registered Successfully");
//        return "registration";
//    }
}
