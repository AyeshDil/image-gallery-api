package com.imagegallery.imagegalleryapi.repo;

import com.imagegallery.imagegalleryapi.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@EnableJpaRepositories
@Repository
public interface UserRepo extends JpaRepository<User, String> {
    Optional<User> findByEmailEquals(String email);
}
