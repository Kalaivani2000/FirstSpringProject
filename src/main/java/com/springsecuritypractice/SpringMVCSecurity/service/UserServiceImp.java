package com.springsecuritypractice.SpringMVCSecurity.service;

import com.springsecuritypractice.SpringMVCSecurity.dto.UserDto;
import com.springsecuritypractice.SpringMVCSecurity.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

public class UserServiceImp implements UserService {

    @Autowired
    public PasswordEncoder passwordEncoder;
    @Override
    public User save(UserDto userDto) {
        User user = new User(userDto.getFullName(),userDto.getEmail(),
                (passwordEncoder.encode(userDto.getPassword())),userDto.getRole());
        return user;
    }
}
