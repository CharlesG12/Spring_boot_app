package com.charles.app.ws.userservice;

import com.charles.app.ws.shared.Utils;
import com.charles.app.ws.ui.model.request.UserDetialsRequestModel;
import com.charles.app.ws.ui.model.response.UserRest;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    private Map<String, UserRest> users;

    private Utils utils;

    @Autowired
    public UserServiceImpl(Utils utils){
        this.utils = utils;
    }

    @Override
    public UserRest createUser(UserDetialsRequestModel userDetails) {
        UserRest response = new UserRest();
        response.setFirstName(userDetails.getFirstName());
        response.setLastName(userDetails.getLastName());
        response.setEmail(userDetails.getEmail());
        response.setPassword(userDetails.getPassword());

        String userId = utils.generateUserId();

        if(users == null)  users = new HashMap<>();
        response.setUserId(userId);
        users.put(userId, response);
        return response;
    }
}
