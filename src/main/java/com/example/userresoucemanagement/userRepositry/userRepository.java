package com.example.userresoucemanagement.userRepositry;

import com.example.userresoucemanagement.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
    public interface userRepository extends JpaRepository<User, String> {

    }


