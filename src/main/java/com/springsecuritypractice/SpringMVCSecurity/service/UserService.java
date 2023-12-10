package com.springsecuritypractice.SpringMVCSecurity.service;

import com.springsecuritypractice.SpringMVCSecurity.dto.UserRegistrationDto;
import com.springsecuritypractice.SpringMVCSecurity.model.User;


public interface UserService {

  User save(UserRegistrationDto userRegistrationDto);


}
