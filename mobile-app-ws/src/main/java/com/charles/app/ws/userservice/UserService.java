package com.charles.app.ws.userservice;

import com.charles.app.ws.ui.model.request.UserDetialsRequestModel;
import com.charles.app.ws.ui.model.response.UserRest;

public interface UserService {
    UserRest createUser(UserDetialsRequestModel userDetails);

}
