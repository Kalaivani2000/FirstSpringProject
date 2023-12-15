package com.springsecuritypractice.SpringMVCSecurity.controller;

import com.springsecuritypractice.SpringMVCSecurity.dto.UserDto;
import com.springsecuritypractice.SpringMVCSecurity.model.User;
import com.springsecuritypractice.SpringMVCSecurity.repository.UserRepository;
import com.springsecuritypractice.SpringMVCSecurity.service.CustomSuccessHandler;
import com.springsecuritypractice.SpringMVCSecurity.service.CustomUserDetail;
import com.springsecuritypractice.SpringMVCSecurity.service.CustomUserDetailService;
import com.springsecuritypractice.SpringMVCSecurity.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.security.Principal;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private CustomUserDetailService customUserDetailService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserDetailsService userDetailsService;


    @GetMapping("/registration")
    public String getRegistrationPage(@ModelAttribute("user")UserDto userDto){

        return "registration";
    }

    @PostMapping("/registration")
    public String saveUser(@ModelAttribute("user")UserDto userDto,Model model){
        userService.save(userDto);
        model.addAttribute("message","Registered Successfully");
        return "registration";
    }

    @GetMapping("/login")
    public String getLoginPage(){

        return "login";
    }

//    @PostMapping("/login")
//    public String loginUser(@ModelAttribute("user") User user, Model model) {
//        User existingUser = userRepository.findByEmail(user.getEmail());
//        if (existingUser != null && existingUser.getPassword().equals(user.getPassword())) {
//            return "/home";
//        } else {
//            model.addAttribute("error", "Invalid email or password");
//            return "login";
//        }
//    }

//
//    @PostMapping("/login")
//    public String loginUser(@ModelAttribute("user") UserDto userDto, Model model,Errors errors) {
//        User existingUser = userRepository.findByEmail(userDto.getEmail());
//
//        if (existingUser != null && existingUser.getEmail() != null && !existingUser.getEmail().isEmpty()) {
//            result.rejectValue("email", null,
//                    "There is already an account registered with the same email");
//        }
//
//        if (result.hasErrors()) {
//            model.addAttribute("user", userDto);
//            return "/registration";
//        }
//
//        userService.save(userDto);
//        return "redirect:/register?success";
//    }

    @PostMapping("/login")
    public String saveLoginUser(@ModelAttribute("user")Model model, Principal principal) {
    UserDetails userDetails = userDetailsService.loadUserByUsername(principal.getName());
        model.addAttribute("home",userDetails);
        return "redirect:/home";
    }


    @GetMapping("/home")
    public String home(){
        return "home";
    }
}
