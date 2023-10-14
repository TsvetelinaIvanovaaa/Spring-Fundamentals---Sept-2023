package bg.softuni.pathfinder.service.impl;

import bg.softuni.pathfinder.model.entity.User;
import bg.softuni.pathfinder.repository.UserRepository;
import bg.softuni.pathfinder.service.RestDemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RestDemoServiceImpl implements RestDemoService {


    private final UserRepository userRepository;

    @Autowired
    public RestDemoServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> getAll() {
        return null;
    }
}
