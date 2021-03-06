package com.restserver.repo;

import com.restserver.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@CrossOrigin("http://localhost:8080")
@RepositoryRestResource(collectionResourceRel = "user", path = "users")
public interface UserRepo extends JpaRepository<UserEntity, Long> {

    UserEntity findByName(String name);

    List<UserEntity> findAll();
}
