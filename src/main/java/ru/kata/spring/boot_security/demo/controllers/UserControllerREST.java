package ru.kata.spring.boot_security.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.kata.spring.boot_security.demo.model.User;
import ru.kata.spring.boot_security.demo.service.UserService;

@RestController
@RequestMapping("/api/")
public class UserControllerREST {
    private final UserService userService;
    @Autowired
    public UserControllerREST(UserService userService) {
        this.userService = userService;
    }
    @GetMapping("/user")
    public ResponseEntity<User> showAuthUser() {
        return new ResponseEntity<> (userService.getCurrentUser(), HttpStatus.OK);
    }
}