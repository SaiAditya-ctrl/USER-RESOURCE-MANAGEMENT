package com.example.userresoucemanagement.userRepositry;


import com.example.userresoucemanagement.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
    public interface ProjectRepositry extends JpaRepository<Project, Long> {
   List<Project> findByUserUserName(String userName);
 }


