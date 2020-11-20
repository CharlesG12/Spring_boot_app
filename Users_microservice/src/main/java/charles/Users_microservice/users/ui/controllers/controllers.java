package charles.Users_microservice.users.ui.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class controllers {

    @GetMapping("/status/check")
    public String status(){
        return "Working";
    }
}
