package com.bridgelabz.springsecurityjwt.controller;


import com.bridgelabz.springsecurityjwt.entity.LoginUser;
import com.bridgelabz.springsecurityjwt.entity.User;
import com.bridgelabz.springsecurityjwt.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
public class Home {
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserService userService;


    //this api is accessible to authenticated user only
    @RequestMapping("/welcome")
    public String welcome(){
        String text = "This is a private page!!! ";
        text+="Only authorized user can access this page!!!";
        return text;
    }

    //this api also accessible to authenticated users only
    @GetMapping("/getUsers")
    public String getUser(){
        return "{\"name\":\"Nikita\"}";
    }


    //registration api permitted to be accessed by all the users
    @PostMapping("/register")
    public ResponseEntity<User> addUser(@RequestBody LoginUser loginUser){
        loginUser.setPassword(passwordEncoder.encode(loginUser.getPassword()));
        User user = userService.addUser(loginUser);
        return ResponseEntity.ok(user);
    }
}
