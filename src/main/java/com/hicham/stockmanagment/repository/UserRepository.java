package com.hicham.stockmanagment.repository;

import com.hicham.stockmanagment.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Integer > {
    Optional<User> findByEmail(String email);

    Optional<User> findByUsername(String username);
}
