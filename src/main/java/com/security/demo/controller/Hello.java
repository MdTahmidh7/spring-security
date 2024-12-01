package com.security.demo.controller;


import com.security.demo.dto.UserDTO;
import com.security.demo.entity.Users;
import com.security.demo.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    public ResponseEntity<Users> createNewUser(@RequestBody UserDTO userDTO){
        Users user = userService.registerUser(userDTO);
        return ResponseEntity.ok(user);
    }

    @PostMapping("/public/login")
    public ResponseEntity<?> loginUser(@RequestBody Users user){

        String jwtToken = userService.verifyUser(user);
        Map<String, String> response = new HashMap<>();
        response.put("token", jwtToken);

        return ResponseEntity.ok(response);
    }

    @GetMapping("/users")
    @CrossOrigin(origins = "http://localhost:4200")
    public List<Users> getAllUser(){
        return userService.getAllUsers();
    }

    @DeleteMapping("/delete-user-by-id")
    public ResponseEntity<?> deleteUserById(@RequestParam Integer id){
        return userService.deleteUserById(id);
    }
}
