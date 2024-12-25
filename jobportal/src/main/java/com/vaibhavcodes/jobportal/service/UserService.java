package com.vaibhavcodes.jobportal.service;


import com.vaibhavcodes.jobportal.entity.JobSeekerProfile;
import com.vaibhavcodes.jobportal.entity.RecruiterProfile;
import com.vaibhavcodes.jobportal.entity.Users;
import com.vaibhavcodes.jobportal.repository.JobSeekerProfileRepository;
import com.vaibhavcodes.jobportal.repository.RecruiterProfileRepository;
import com.vaibhavcodes.jobportal.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;
    @Autowired
    RecruiterProfileRepository recruiterProfileRepository;
    @Autowired
    JobSeekerProfileRepository jobSeekerProfileRepository;

    public Users userRegistration(Users user){
        user.setActive(true);
        user.setRegistrationDate(new Date(System.currentTimeMillis()));
        Users savedUser =userRepository.save(user);
        Integer userId = savedUser.getUserTypeId().getUserTypeId();
        if(userId.equals(1)){
            System.out.println(savedUser.toString());
            recruiterProfileRepository.save(new RecruiterProfile(savedUser));
        }else{
            jobSeekerProfileRepository.save(new JobSeekerProfile());
        }
        return savedUser;
    }

    public Boolean getUserByEmail(Users user){
        Integer userId = user.getUserId();
        String email = user.getEmail();
        Optional<Users> dbUser = userRepository.findByEmail(email);
        return dbUser.isPresent();
    }
}
