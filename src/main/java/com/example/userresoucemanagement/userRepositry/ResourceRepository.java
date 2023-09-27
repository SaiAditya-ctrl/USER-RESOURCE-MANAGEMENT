package com.example.userresoucemanagement.userRepositry;


import com.example.userresoucemanagement.entity.Resource;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
    public interface ResourceRepository extends JpaRepository<Resource, Long> {
    }


