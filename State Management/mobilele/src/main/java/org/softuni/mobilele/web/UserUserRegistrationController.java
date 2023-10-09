package org.softuni.mobilele.web;

import org.softuni.mobilele.model.dto.UserRegistrationDTO;
import org.softuni.mobilele.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/users")
@Controller
public class UserUserRegistrationController {

    private final UserService userService;
    public UserUserRegistrationController(UserService userService) {

        this.userService = userService;
    }
    @GetMapping("/register")
    public String register() {
        return "auth-register";
    }

    //TODO: Registration email with activation link
    @PostMapping("/register")
    public String register(UserRegistrationDTO userRegistrationDTO) {
        return "redirect:/";
    }
}
