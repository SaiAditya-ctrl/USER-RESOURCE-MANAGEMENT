package com.example.userresoucemanagement.service;


import com.example.userresoucemanagement.entity.Formula;
import com.example.userresoucemanagement.userRepositry.FormulaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class FormulaService {

    @Autowired
    private FormulaRepository formulaRepository;

    public List<Formula> getAllFormulas() {
        return formulaRepository.findAll();
    }

    public Formula getFormulaById(Long id) {
        return formulaRepository.findById(id).orElse(null);
    }

    public void addFormula(Formula formula) {
        formulaRepository.save(formula);
    }

    public void updateFormula(Formula formula) {
        formulaRepository.save(formula);
    }

    public void deleteFormula(Long id) {
        formulaRepository.deleteById(id);
    }
}

