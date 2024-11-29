package com.security.demo.controller;

import com.security.demo.entity.Users;
import com.security.demo.repo.UserRepo;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.*;

@RestController
public class Hello {

    @Autowired
    private UserRepo userRepo;


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
        return userRepo.findById(id).get();
    }
}
