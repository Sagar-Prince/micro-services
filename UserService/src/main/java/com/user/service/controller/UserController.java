package com.user.service.controller;

import com.user.service.entity.User;
import com.user.service.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserServiceImpl userService;

    @PostMapping("/saveUser")
    public ResponseEntity<User> getUser(@RequestBody User user) {
        User user1 = userService.saveUser(user);
        return new ResponseEntity<>(user1, HttpStatus.CREATED);
    }

    @GetMapping("/allUser")
    public ResponseEntity<List<User>> getAllUser() {
        List<User> allUser = userService.getAllUser();
        return new ResponseEntity<>(allUser, HttpStatus.OK);
    }

    @GetMapping("/userById/{userId}")
    public ResponseEntity<User> getUserById(@PathVariable String userId) {
        User userById = userService.getUserById(userId);
        return new ResponseEntity<>(userById, HttpStatus.OK);
    }
}