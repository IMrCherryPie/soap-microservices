package com.example.fluxclient.service;

import com.example.fluxclient.entity.UserEntity;
import com.example.fluxclient.repo.CustomWebClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
public class UserService {

    @Autowired
    CustomWebClient client;

    public Mono<UserEntity> getUserById(Integer id){
        return client.flux_server_app.get()
                .uri("/user/{id}", id)
                .retrieve()
                .bodyToMono(UserEntity.class);
    }

    public Flux<UserEntity> getUsers(){
        return client.flux_server_app.get()
                .uri("/list")
                .retrieve()
                .bodyToFlux(UserEntity.class);
    }

}
