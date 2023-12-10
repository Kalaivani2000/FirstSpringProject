package com.springsecuritypractice.SpringMVCSecurity.controller;

import com.springsecuritypractice.SpringMVCSecurity.dto.UserRegistrationDto;
import com.springsecuritypractice.SpringMVCSecurity.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserRegistartionController {

    @Autowired
    private UserService userService;

    public UserRegistartionController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/registrationForm")
    public String userRegistrationAccount(@ModelAttribute("user")UserRegistrationDto userRegistrationDto){

        userService.save(userRegistrationDto);

        return "Successfully";
    }

    @GetMapping("/registrationForm")
    public String getRegistrationPage(@ModelAttribute("user") UserRegistrationDto userRegistrationDto,
                                   Model model){
        UserRegistrationDto user = new UserRegistrationDto();
        model.addAttribute("user",user);
        return "registration";
    }
}
