package com.nextgenretro.nextgenretro.model.controller;

import com.nextgenretro.nextgenretro.model.entities.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    @GetMapping
    public ResponseEntity<User> findAll(){
        User user = new User ( "Wellerson", "Wellerson@gmail.com", "12345678", "");
        return ResponseEntity.ok().body(user);
    }
}
