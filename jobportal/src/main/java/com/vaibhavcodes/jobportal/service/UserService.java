package com.vaibhavcodes.jobportal.service;


import com.vaibhavcodes.jobportal.entity.Users;
import com.vaibhavcodes.jobportal.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public Users userRegistration(Users user){
        user.setActive(true);
        user.setRegistrationDate(new Date(System.currentTimeMillis()));
        return userRepository.save(user);
    }

    public Boolean getUserByEmail(Users user){
        Integer userId = user.getUserId();
        String email = user.getEmail();
        Optional<Users> dbUser = userRepository.findByEmail(email);
        return dbUser.isPresent();
    }
}
