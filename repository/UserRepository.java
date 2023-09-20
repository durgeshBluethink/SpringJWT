package com.security.springSecurity.repository;

import com.security.springSecurity.entitys.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
}
