package com.charles.app.ws.ui.controller;

import com.charles.app.ws.exceptions.UserServiceException;
import com.charles.app.ws.ui.model.request.UpdateDetialsRequestModel;
import com.charles.app.ws.ui.model.request.UserDetialsRequestModel;
import com.charles.app.ws.ui.model.response.UserRest;
import com.charles.app.ws.userservice.UserService;
import com.charles.app.ws.userservice.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.MediaType;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("users") //  http://localhost:8080/users
public class UserController {
    private Map<String, UserRest> users;

    @Autowired
    UserService userService;

    @GetMapping
    public String getUser(@RequestParam(value="page", defaultValue = "1") int page,
                          @RequestParam(value="limit", defaultValue="1") int limit,
                          @RequestParam(value="sort", required = false) String sort){
        return "get user was called with page " + page + " limit " + limit + " sort " + sort;
    }

    @GetMapping(path="/{userid}",
                 produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<UserRest> getUser(@PathVariable String userid){

        if(true) throw new UserServiceException("A new user exception was called.");

        String firstname = null;

        Integer firstnameleng = firstname.length();

        if(users.containsKey(userid)) {
            return new ResponseEntity<>(users.get(userid), HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
                produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<UserRest> createUser(@Valid @RequestBody UserDetialsRequestModel request, BindingResult bindingResult){
        UserRest response = userService.createUser(request);
        return new ResponseEntity<UserRest>(response, HttpStatus.OK);
    }

    @PutMapping(path="/{userid}",
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<UserRest> updateUser(@PathVariable String userid, @Valid @RequestBody UpdateDetialsRequestModel request){
        UserRest storedUserDetails = users.get(userid);
        storedUserDetails.setFirstName(request.getFirstName());
        storedUserDetails.setLastName(request.getLastName());

        users.put(userid, storedUserDetails);
        return new ResponseEntity<UserRest>(storedUserDetails, HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity deleteUser(@PathVariable String userid) {
        users.remove(userid);
        return ResponseEntity.noContent().build();
    }
}
