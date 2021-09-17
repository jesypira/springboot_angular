package com.pira.springboot_angular.repository;

import com.pira.springboot_angular.model.entity.ApiUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<ApiUser, Long> {

    boolean existsByUsername(String username);

    Optional<ApiUser> findByUsername(String username);
}
