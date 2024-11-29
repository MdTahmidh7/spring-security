package com.security.demo.service;

import com.security.demo.entity.Users;
import com.security.demo.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;

    private BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder(12);

    public Users registerUser(Users user){
        if(user != null){
            user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
            return userRepo.save(user);
        }
        return null;
    }

    public List<Users> getAllUsers(){
       return userRepo.findAll();
    }

    public Users findUserById(Integer id) {
        return userRepo.findById(id).get();
    }

    public ResponseEntity<?> deleteUserById(Integer id) {

        if(userRepo.findById(id).isPresent()){
            userRepo.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }

        userRepo.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }
}
