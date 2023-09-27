package com.example.userresoucemanagement.userRepositry;


import com.example.userresoucemanagement.entity.Formula;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FormulaRepository extends JpaRepository<Formula, Long> {
}
