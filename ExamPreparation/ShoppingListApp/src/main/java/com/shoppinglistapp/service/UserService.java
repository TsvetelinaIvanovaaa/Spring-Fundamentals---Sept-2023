package com.shoppinglistapp.service;

import com.shoppinglistapp.model.dto.user.UserLoginBindingModel;
import com.shoppinglistapp.model.dto.user.UserRegisterBindingModel;


public interface UserService {

    boolean register (UserRegisterBindingModel userRegisterBindingModel);

    boolean login(UserLoginBindingModel userLoginBindingModel);
}
