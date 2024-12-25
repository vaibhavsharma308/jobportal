package com.vaibhavcodes.jobportal.service;

import com.vaibhavcodes.jobportal.entity.UsersType;
import com.vaibhavcodes.jobportal.repository.UserRepository;
import com.vaibhavcodes.jobportal.repository.UserTypeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserTypeService {

    private final UserTypeRepository userTypeRepository;
    public UserTypeService(UserTypeRepository userTypeRepository){
        this.userTypeRepository=userTypeRepository;
    }
    public List<UsersType> getAll(){
        return  userTypeRepository.findAll();
    }
}
