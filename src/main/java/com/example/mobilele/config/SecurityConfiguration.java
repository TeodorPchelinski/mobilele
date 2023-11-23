package com.example.mobilele.config;

import com.example.mobilele.service.impl.MobileleUserDetailsService;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfiguration {

    @Bean
    public SecurityFilterChain filterChain (HttpSecurity httpSecurity) throws Exception {
        // todo: Configuration


        httpSecurity.authorizeHttpRequests(
                //Define which urls are visible by which users
                authorizeRequests -> authorizeRequests
                        //All static resources which are situated in js, images, css are available for anyone
                        .requestMatchers(PathRequest.toStaticResources().atCommonLocations()).permitAll()
                        // Allow anyone to see the home page, registration page and login
                        .requestMatchers("/", "/users/login", "/users/register").permitAll()
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
                            .failureUrl("/users/login-error");
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
    public UserDetailsService userDetailsService() {
        return new MobileleUserDetailsService();
    }

}
