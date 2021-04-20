package com.ada.adalibrary.resources;

import com.ada.adalibrary.domain.User;
import com.ada.adalibrary.services.UserService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/users")
public class UserMain {

    @Autowired
    UserService userService;


    @PostMapping("/login")
    public ResponseEntity<Map<String, String>> login(@RequestBody Map<String, Object> usersMap) {
        String email = (String) usersMap.get("email");
        String password = (String) usersMap.get("password");
        User user = userService.validate(email, password);
        Map<String, String> map = new HashMap<>();
        map.put("message", "loggedIn successfully");
        return  new ResponseEntity<>(map, HttpStatus.OK);
    }

    @PostMapping("/register")
    public ResponseEntity<Map<String, String>> register(@RequestBody Map<String, Object> usersMap) {
        String firstname = (String) usersMap.get("firstname");
        String lastname = (String) usersMap.get("lastname");
        String email = (String) usersMap.get("email");
        String password = (String) usersMap.get("password");
        User user = userService.registerUser(firstname, lastname, email, password);
        Map<String, String> map = new HashMap<>();
        map.put("message", "registered successfully");
        return new ResponseEntity<>(map, HttpStatus.OK);


    }
}
