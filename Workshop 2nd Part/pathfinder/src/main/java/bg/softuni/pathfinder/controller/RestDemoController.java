package bg.softuni.pathfinder.controller;

import bg.softuni.pathfinder.model.entity.User;
import bg.softuni.pathfinder.service.RestDemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RestDemoController {

    private final RestDemoService restDemoService;

    @Autowired
    public RestDemoController(RestDemoService restDemoService) {
        this.restDemoService = restDemoService;
    }

   //@RequestMapping(path = "/users/all", method = RequestMethod.GET)
    @GetMapping("/users/all")
    public List<User> getAll() {
        return this.restDemoService.getAll();
    }
}
