package com.example.mobilele.web;

import com.example.mobilele.model.dto.UserRegistrationDTO;
import com.example.mobilele.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class UserRegistrationController {

    private final UserService userService;

    public UserRegistrationController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users/register")
    public  String register() {
        return "auth-register";
    }


    @PostMapping("/users/register")
    public String register(UserRegistrationDTO userRegistrationDTO){
        //@RequestBody -> Expects JSON or XML (We had an error 15 when put in front of UserRegistration userRegistrationDTO)

        userService.registerUser(userRegistrationDTO);

        return "redirect:/";
    }
}
