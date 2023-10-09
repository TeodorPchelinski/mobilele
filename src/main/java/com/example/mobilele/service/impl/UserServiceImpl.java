package com.example.mobilele.service.impl;

import com.example.mobilele.model.dto.UserRegistrationDTO;
import com.example.mobilele.model.entity.UserEntity;
import com.example.mobilele.repository.UserRepository;
import com.example.mobilele.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    public UserServiceImpl(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public void registerUser(UserRegistrationDTO userRegistrationDTO) {
        //System.out.println(userRegistrationDTO);// N E V E R    We are printing passwords!

        userRepository.save(map(userRegistrationDTO));
    }

    private static UserEntity map(UserRegistrationDTO userRegistrationDTO){
        return new UserEntity()
                .setActive(true)
                .setFirstName(userRegistrationDTO.firstName())
                .setLastName(userRegistrationDTO.lastName())
                .setEmail(userRegistrationDTO.email())
                .setPassword(userRegistrationDTO.password());
    }
}
