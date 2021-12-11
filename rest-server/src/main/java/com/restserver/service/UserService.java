package com.restserver.service;


import com.restserver.entity.UserEntity;
import com.restserver.repo.UserRepo;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private final UserRepo userRepository;

    public UserService(UserRepo userRepository) {
        this.userRepository = userRepository;
    }

    public Iterable<UserEntity> getUsers(){
        return userRepository.findAll();
    }

    public Optional<UserEntity> findById(Long id){
        return userRepository.findById(id);
    }

    public UserEntity saveOrUpdate(UserEntity entity){
        userRepository.save(entity);
        return userRepository.findByName(entity.getName());
    }

    public void deleteById(Long id){
        userRepository.deleteById(id);
    }

}