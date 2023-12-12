package com.dictionaryapp.service;

import com.dictionaryapp.model.entity.User;
import com.dictionaryapp.model.service.UserServiceModel;
import com.dictionaryapp.repo.UserRepository;
import com.dictionaryapp.util.LoggedUser;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final ModelMapper modelMapper;
    private final LoggedUser loggedUser;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder, ModelMapper modelMapper, LoggedUser loggedUser) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.modelMapper = modelMapper;
        this.loggedUser = loggedUser;
    }

    public UserServiceModel registerUser(UserServiceModel userServiceModel) {
        User user = modelMapper.map(userServiceModel, User.class);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return modelMapper.map(userRepository.save(user), UserServiceModel.class);
    }

    public UserServiceModel findByUsernameAndPassword(String username, String password) {
        Optional<User> userOptional = userRepository.findByUsername(username);

        return userOptional.map(user -> {
            if (passwordEncoder.matches(password, user.getPassword())) {
                return modelMapper.map(user, UserServiceModel.class);
            } else {
                return null;
            }
        }).orElse(null);
    }
    public void loginUser(Long id, String username) {
        loggedUser.setId(id);
        loggedUser.setUsername(username);
    }

    public User findById(Long id) {
        return userRepository.findById(id).orElse(null);
    }
}
