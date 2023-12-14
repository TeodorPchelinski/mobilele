package com.example.mobilele.service.impl;

import com.example.mobilele.model.entity.UserEntity;
import com.example.mobilele.model.entity.UserRoleEntity;
import com.example.mobilele.repository.UserRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.List;

/** Don't put @Service because it is already a @Bean in SecurityConfiguration */

public class MobileleUserDetailsService implements UserDetailsService {


    private UserRepository userRepository;

    public MobileleUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        return userRepository.findByEmail(email)
                .map(MobileleUserDetailsService::map)
                .orElseThrow(() -> new UsernameNotFoundException("User" + email + " was not found"));

    }

    private static UserDetails map(UserEntity userEntity) {

        //Very Important -> UserDeatils = User.withUsername... return userDetails   AND NOT -> return User.withUsername...

        UserDetails userDetails = User.withUsername(userEntity.getEmail())
                .password(userEntity.getPassword())
                .authorities(userEntity.getRoles().stream().map(MobileleUserDetailsService::map).toList()) //TODO: add roles
                .build();

        return userDetails;
    }

    private static GrantedAuthority map(UserRoleEntity userRoleEntity) {
        return new SimpleGrantedAuthority("ROLE_" + userRoleEntity.getRole().name());

    }

}
