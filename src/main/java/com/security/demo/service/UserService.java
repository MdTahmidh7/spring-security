package com.security.demo.service;

import com.security.demo.dto.CustomUserDto;
import com.security.demo.dto.UserDTO;
import com.security.demo.entity.Users;
import com.security.demo.exception.UserAlreadyExistsException;
import com.security.demo.exception.UserNotFoundByUsernameAndEmail;
import com.security.demo.mapper.UserMapper;
import com.security.demo.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JWTService jwtService;

    @Autowired
    private UserMapper userMapper;

    private BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder(12);

    public Users registerUser(UserDTO userDTO){
        if(userDTO != null){

            if(userRepo.findByUsername(userDTO.getUsername()).isPresent()){
                throw new UserAlreadyExistsException("User with username: " + userDTO.getUsername() + " already exists!");
            }

            Users user = userMapper.userDTOToUser(userDTO);
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

    public String verifyUser(Users user) {

        Authentication authentication = authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(
                        user.getUsername(),
                        user.getPassword())
                );

        if (authentication.isAuthenticated()) {
            return jwtService.generateToken(user);
        }
        return "failed";
    }

    public ResponseEntity<CustomUserDto> verifyUser(String username, String email) {

        List<Object[]> results = userRepo.findByUsernameAndEmail(username, email);
        List<CustomUserDto> userDTOs = results
                .stream()
                .map(row -> new CustomUserDto((String) row[0], (String) row[1]))  // Map each row to UserDTO
                .toList();

        userDTOs.forEach(dto -> {
            System.out.println("Username: " + dto.getUsername());
            System.out.println("Email: " + dto.getEmail());
        });

        if(userDTOs.isEmpty()){
            throw new UserNotFoundByUsernameAndEmail("User not found by username: " + username + " and email: " + email + "!");
        }else{
            //return user in response
            return ResponseEntity.ok(userDTOs.get(0));
        }
    }
}
