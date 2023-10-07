package bg.softuni.pathfinder.controller;

import bg.softuni.pathfinder.model.User;
import bg.softuni.pathfinder.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

   //@RequestMapping(path = "/users/all", method = RequestMethod.GET)
    @GetMapping("/users/all")
    public List<User> getAll() {
        return this.userService.getAll();
    }
}
