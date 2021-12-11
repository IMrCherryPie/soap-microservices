package com.restserver.controller;

import com.restserver.entity.UserEntity;
import com.restserver.service.UserService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/users")
@CrossOrigin("http://localhost:8081")
public class RestController {

    UserService userService;

    public RestController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/list")
    public ResponseEntity<Iterable<UserEntity>> getAllUsers() {
        return new ResponseEntity<>(userService.getUsers(), HttpStatus.OK);
    }

    @GetMapping({"/{id}"})
    public ResponseEntity<Optional<UserEntity>> getUser(@PathVariable Long id) {
        return new ResponseEntity<>(userService.findById(id), HttpStatus.OK);
    }


    @PostMapping({"/save"})
    public ResponseEntity<UserEntity> saveUser(@RequestBody UserEntity userEntity) {
        UserEntity user = userService.saveOrUpdate(userEntity);
        HttpHeaders httpHeaders = new HttpHeaders();
        return new ResponseEntity<>(user, httpHeaders, HttpStatus.CREATED);
    }

    @DeleteMapping({"/delete/{id}"})
    public ResponseEntity<UserEntity> deleteUser(@PathVariable("id") Long id) {
        userService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}