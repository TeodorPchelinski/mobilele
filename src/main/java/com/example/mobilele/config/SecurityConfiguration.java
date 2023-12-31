package com.example.mobilele.config;

import com.example.mobilele.model.enums.UserRoleEnum;
import com.example.mobilele.repository.UserRepository;
import com.example.mobilele.service.impl.MobileleUserDetailsService;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfiguration {
    private final UserRepository userRepository;

    public SecurityConfiguration(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Bean
    public SecurityFilterChain filterChain (HttpSecurity httpSecurity) throws Exception {
        // todo: Configuration


        httpSecurity.authorizeHttpRequests(
                //Define which urls are visible by which users
                authorizeRequests -> authorizeRequests
                        //All static resources which are situated in js, images, css are available for anyone
                        .requestMatchers(PathRequest.toStaticResources().atCommonLocations()).permitAll()
                        // Allow anyone to see the home page, registration page and login
                        .requestMatchers("/", "/users/login", "/users/register", "/users/login-error").permitAll()
                        .requestMatchers("/", "/offers/all").permitAll()
                        .requestMatchers("/", "/brands").hasRole(UserRoleEnum.ADMIN.name())
                        // All requests are authenticated
                        .anyRequest().authenticated()
        ).formLogin(
                formLogin -> {
                    formLogin
                            // redirect here when we access something which is not allowed
                            // also this is the page where we perform login.
                            .loginPage("/users/login")
                            // The names of the input fields (in our case in auth-login.html)
                            .usernameParameter("email")
                            .passwordParameter("password")
                            .defaultSuccessUrl("/")
                            .failureForwardUrl("/users/login-error");
                }

        ).logout(
                logout -> {
                    // the URL where we should POST in order to logout
                    logout.logoutUrl("/users/logout")
                            .logoutSuccessUrl("/")
                            // delete the HTTP Session
                            .invalidateHttpSession(true);

                }
        );

            //TODO: Remember me

        return httpSecurity.build();

    }

    @Bean
    public UserDetailsService userDetailsService(UserRepository userRepository) {
        // translate mobile users and roles to understandable representation for Spring Security
        return new MobileleUserDetailsService(userRepository);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return Pbkdf2PasswordEncoder.defaultsForSpringSecurity_v5_8();
    }

}
