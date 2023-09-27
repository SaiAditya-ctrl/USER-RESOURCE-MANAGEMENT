package com.example.userresoucemanagement.userRepositry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResourceDetailsRepository extends JpaRepository<com.example.userresoucemanagement.entity.ResourceDetails, Long> {

}
