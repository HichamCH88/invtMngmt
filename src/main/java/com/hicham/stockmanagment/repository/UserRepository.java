package com.hicham.stockmanagment.repository;

import com.hicham.stockmanagment.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer > {
}
