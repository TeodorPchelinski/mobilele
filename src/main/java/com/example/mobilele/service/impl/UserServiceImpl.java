package com.example.mobilele.service.impl;

import com.example.mobilele.model.dto.UserLoginDTO;
import com.example.mobilele.model.dto.UserRegistrationDTO;
import com.example.mobilele.model.entity.UserEntity;
import com.example.mobilele.repository.UserRepository;
import com.example.mobilele.service.UserService;
import com.example.mobilele.util.CurrentUser;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final CurrentUser currentUser;

    // Spring Security is needed here after the second half of the course will be learned
    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder, CurrentUser currentUser){
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.currentUser = currentUser;
    }

    @Override
    public void registerUser(UserRegistrationDTO userRegistrationDTO) {
        //System.out.println(userRegistrationDTO);// N E V E R    We are printing passwords!

        userRepository.save(map(userRegistrationDTO));
    }


    @Override
    public boolean loginUser(UserLoginDTO userLoginDTO) {
        var userEntity = userRepository
               .findByEmail(userLoginDTO.email())
               .orElse(null);

        boolean loginSuccess = false;

        if (userEntity != null) {


            String rawPassword = userLoginDTO.password();
            String encodedPassword = userEntity.getPassword();
            loginSuccess = encodedPassword != null &&
                    passwordEncoder.matches(rawPassword, encodedPassword);


            if (loginSuccess) {
                currentUser.setLogged(true)
                        .setFirstName(userEntity.getFirstName())
                        .setLastName(userEntity.getLastName());
            } else {
                currentUser.logout();
            }
        }
        return loginSuccess;
    }


    private UserEntity map(UserRegistrationDTO userRegistrationDTO){
        return new UserEntity()
                .setActive(true)
                .setFirstName(userRegistrationDTO.firstName())
                .setLastName(userRegistrationDTO.lastName())
                .setEmail(userRegistrationDTO.email())
                .setPassword(passwordEncoder.encode(userRegistrationDTO.password()));
    }
}
