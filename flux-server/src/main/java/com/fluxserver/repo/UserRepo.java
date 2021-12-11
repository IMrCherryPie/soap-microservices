package com.fluxserver.repo;

import com.fluxserver.entity.UserEntity;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

public interface UserRepo extends ReactiveCrudRepository<UserEntity, Integer> {

    Flux<UserEntity> findAllById(Integer id);
}
