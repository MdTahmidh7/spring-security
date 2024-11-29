package com.security.demo.controller;


import com.security.demo.entity.Users;
import com.security.demo.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class Hello {

    @Autowired
    private UserService userService;


    @GetMapping("")
    public String sayHello(HttpServletRequest request){
        return "Hello " + request.getAuthType() + " "+request.getSession().getId();
    }

    @GetMapping("/csrf-token")
    public CsrfToken getCSRFToken(HttpServletRequest request){
        return (CsrfToken)request.getAttribute("_csrf");
    }

    @PostMapping("/post-hello")
    public String postHello(@RequestBody String message){
        return message;
    }

    @GetMapping("/public")
    public Users getCSRFToken(@RequestParam Integer id){
        return userService.findUserById(id);
    }

    @PostMapping("/public/register")
    public Users createNewUser(@RequestBody Users user){
       return userService.registerUser(user);
    }

    @GetMapping("/public/users")
    public List<Users> getAllUser(){
        return userService.getAllUsers();
    }

    @DeleteMapping("/delete-user-by-id")
    public ResponseEntity<?> deleteUserById(@RequestParam Integer id){
        return userService.deleteUserById(id);
    }
}
