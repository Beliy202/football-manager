package com.example.footballmanager.controller;

import com.example.footballmanager.dto.SaveUserDto;
import com.example.footballmanager.entity.User;
import com.example.footballmanager.servise.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/registration")
    public ResponseEntity<String> saveUser(@RequestBody SaveUserDto saveUserDto) {
        User user = User.builder()
                .username(saveUserDto.getUsername())
                .password(saveUserDto.getPassword())
                .name(saveUserDto.getName())
                .build();
        userService.save(user);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/registration/admin")
    public ResponseEntity<String> saveAdmin() {
        userService.saveAdmin();
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/find/{username}")
    public ResponseEntity<User> getUserByUsername(@PathVariable("username") String username) {
        return new ResponseEntity<>(userService.findByUsername(username), HttpStatus.OK);
    }


}
