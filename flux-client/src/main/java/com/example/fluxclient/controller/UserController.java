package com.example.fluxclient.controller;

import com.example.fluxclient.entity.UserEntity;
import com.example.fluxclient.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
@RequestMapping("/")
public class UserController {

    @Autowired
    private final UserService userService;

    @GetMapping("/list")
    public Flux<UserEntity> getUsers(){
        return userService.getUsers();
    }
    @GetMapping("/user/{id}")
    public Mono<UserEntity> getUser(@PathVariable("id") Integer id){
        return userService.getUserById(id);
    }
}

