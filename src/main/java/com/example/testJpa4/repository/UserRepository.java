package com.example.testJpa4.repository;


import com.example.testJpa4.entity.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
    public interface UserRepository extends JpaRepository<User, Long> {
    }

