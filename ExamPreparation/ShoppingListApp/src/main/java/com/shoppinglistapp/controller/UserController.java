package com.shoppinglistapp.controller;

import com.shoppinglistapp.model.dto.user.UserLoginBindingModel;
import com.shoppinglistapp.model.dto.user.UserRegisterBindingModel;
import com.shoppinglistapp.service.UserService;
import com.shoppinglistapp.util.LoggedUser;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {

    private final UserService userService;
    private final ModelMapper modelMapper;
    private final LoggedUser loggedUser;

    public UserController(UserService userService, ModelMapper modelMapper, LoggedUser loggedUser) {
        this.userService = userService;
        this.modelMapper = modelMapper;
        this.loggedUser = loggedUser;
    }

    @GetMapping("/login")
    public ModelAndView login(@ModelAttribute ("userLoginBindingModel") UserLoginBindingModel userLoginBindingModel) {
        if (loggedUser.getId() != null) {
            return new ModelAndView("/login");
        }
        return new ModelAndView("login");
    }

    @PostMapping("/login")
    public ModelAndView login(@ModelAttribute ("userLoginBindingModel") @Valid UserLoginBindingModel userLoginBindingModel,
                              BindingResult bindingResult) {
        if (loggedUser.getId() != null) {
            return new ModelAndView("redirect:/home");
        }
        if (bindingResult.hasErrors()) {
            return new ModelAndView("login");
        }
        boolean hasSuccessfulLogin = userService.login(userLoginBindingModel);
        if (!hasSuccessfulLogin) {
            ModelAndView modelAndView = new ModelAndView("login");
            modelAndView.addObject("hasSuccessfulLogin", true);
            return modelAndView;
        }
        return new ModelAndView("redirect:/home");
    }


    @GetMapping("/register")
    public ModelAndView register(@ModelAttribute ("userRegisterBindingModel") UserRegisterBindingModel userRegisterBindingModel) {
        if (loggedUser.getId() != null) {
            return new ModelAndView("redirect:/home");
        }
        return new ModelAndView("register");
    }

    @PostMapping("/register")
    public ModelAndView register(@ModelAttribute ("userRegisterBindingModel") @Valid UserRegisterBindingModel userRegisterBindingModel,
                                 BindingResult bindingResult) {
        if (loggedUser.getId() != null) {
            return new ModelAndView("redirect:/home");
        }
        if (bindingResult.hasErrors()) {
            return new ModelAndView("register");
        }
        boolean hasSuccessfulRegistration = userService.register(userRegisterBindingModel);
        if (!hasSuccessfulRegistration) {
            ModelAndView modelAndView = new ModelAndView("register");
            modelAndView.addObject("hasSuccessfulRegistration", true);
            return modelAndView;
        }
        return new ModelAndView("redirect:/login");
    }
}
