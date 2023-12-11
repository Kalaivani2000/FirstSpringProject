package com.springsecuritypractice.SpringMVCSecurity.controller;

import com.springsecuritypractice.SpringMVCSecurity.dto.UserDto;
import com.springsecuritypractice.SpringMVCSecurity.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

    private UserService userService;

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
