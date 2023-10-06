package com.example.mobilele.service.impl;

import com.example.mobilele.model.dto.UserRegistrationDTO;
import com.example.mobilele.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {


    @Override
    public void registerUser(UserRegistrationDTO userRegistrationDTO) {
        System.out.println(userRegistrationDTO);// N E V E R    We are printing passwords!
    }
}
