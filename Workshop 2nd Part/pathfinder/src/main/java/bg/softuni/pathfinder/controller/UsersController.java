package bg.softuni.pathfinder.controller;

import bg.softuni.pathfinder.model.dto.UserLoginBindingModel;
import bg.softuni.pathfinder.model.dto.UserRegisterBindingModel;
import bg.softuni.pathfinder.service.AutenticationService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("users")
public class UsersController {

    private final AutenticationService autenticationService;

    public UsersController(AutenticationService autenticationService) {
        this.autenticationService = autenticationService;
    }

    @GetMapping("/login")
    public ModelAndView login(){

        return new ModelAndView("login");
    }

    @PostMapping("/login")
    public ModelAndView login(UserLoginBindingModel userLoginBindingModel){
        boolean isLogged = autenticationService.login(userLoginBindingModel);
        if(isLogged){
            return new ModelAndView("redirect:/");
        }
        return new ModelAndView("login");
    }
    @GetMapping("/register")
    public ModelAndView register() {

        return new ModelAndView("register");
    }

    @PostMapping("/register")
    public ModelAndView register(UserRegisterBindingModel userRegisterBindingModel) {
        this.autenticationService.register(userRegisterBindingModel);

        return new ModelAndView("redirect:login");
    }

    //TODO change to POST
    @GetMapping("/logout")
    public ModelAndView logout() {
        this.autenticationService.logout();

        return new ModelAndView("redirect:/");
    }
}
