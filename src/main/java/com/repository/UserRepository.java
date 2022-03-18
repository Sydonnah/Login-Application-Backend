package com.repository;

import com.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserModel,Integer> {
    UserModel findByUsername(String username);
}
