package com.example.userrestsecurityjwt.repository;

import com.example.userrestsecurityjwt.model.Role;
import com.example.userrestsecurityjwt.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String name);

}
