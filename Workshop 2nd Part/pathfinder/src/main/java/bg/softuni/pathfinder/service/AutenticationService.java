package bg.softuni.pathfinder.service;

import bg.softuni.pathfinder.model.dto.UserLoginBindingModel;
import bg.softuni.pathfinder.model.dto.UserRegisterBindingModel;


public interface AutenticationService {

    void register(UserRegisterBindingModel userRegisterBindingModel);

    boolean login(UserLoginBindingModel userLoginBindingModel);

    void logout();
}
