package com.soapserver.service;

import com.soap.gen.User;
import com.soapserver.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepo userRepo;

    public List<User> findUser(User user){
        List<User> users = userRepo.findAllByName(user.getName());
        if(users.size() == 0){
            saveUser(user);
        }
        return users;
    }

    public Optional<User> findUserById(Long id){
        return userRepo.findById(id);
    }

    public void saveUser(User user){
        userRepo.save(user);
    }

    public List<User> findUsers() {
        return userRepo.findAll();
    }
}
