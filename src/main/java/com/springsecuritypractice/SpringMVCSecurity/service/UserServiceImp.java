package com.springsecuritypractice.SpringMVCSecurity.service;

import com.springsecuritypractice.SpringMVCSecurity.dto.UserRegistrationDto;
import com.springsecuritypractice.SpringMVCSecurity.model.Role;
import com.springsecuritypractice.SpringMVCSecurity.model.User;
import com.springsecuritypractice.SpringMVCSecurity.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class UserServiceImp implements UserService{

    @Autowired
    private UserRepo userRepo;

    public UserServiceImp(UserRepo userRepo) {
        this.userRepo = userRepo;
    }
    @Override
    public User save(UserRegistrationDto userRegistrationDto) {
       User user=new User(userRegistrationDto.getFirstName(),
               userRegistrationDto.getLastName(),
               userRegistrationDto.getEmail(),
               userRegistrationDto.getPassword(),Arrays.asList(new Role("ROLE_USER")));
        return userRepo.save(user);
    }
}
