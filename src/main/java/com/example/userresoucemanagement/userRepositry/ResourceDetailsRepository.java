package com.example.userresoucemanagement.userRepositry;
import com.example.userresoucemanagement.entity.ResourceDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResourceDetailsRepository extends JpaRepository<ResourceDetails, Long> {

}
