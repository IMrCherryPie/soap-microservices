package com.fluxserver.controller;

import com.fluxserver.entity.UserEntity;
import com.fluxserver.service.UserService;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/list")
    public Flux<UserEntity> getUsers(){
        return userService.getAllUsers();
    }
    @GetMapping("/user/{id}")
    public Mono<UserEntity> getUser(@PathVariable("id") Integer id){
        return userService.getUserById(id);
    }

}