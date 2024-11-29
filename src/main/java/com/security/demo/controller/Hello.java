package com.security.demo.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Hello {


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
}
