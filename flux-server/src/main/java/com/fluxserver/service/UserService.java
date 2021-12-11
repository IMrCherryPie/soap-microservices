package com.fluxserver.service;


import com.fluxserver.entity.UserEntity;
import com.fluxserver.repo.UserRepo;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class UserService {

    private final UserRepo userRepo;

    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    public Flux<UserEntity> getAllUsersById(Integer id){
        return userRepo.findAllById(id);
    }

    public Flux<UserEntity> getAllUsers(){
        return userRepo.findAll();
    }

    public Mono<UserEntity> getUserById(Integer id){
        return userRepo.findById(id);
    }

    public void save(UserEntity user) {
        userRepo.save(user);
    }
}
