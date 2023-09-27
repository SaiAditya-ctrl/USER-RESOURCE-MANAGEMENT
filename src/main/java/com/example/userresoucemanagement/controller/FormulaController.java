package com.example.userresoucemanagement.controller;

import com.example.userresoucemanagement.entity.Formula;
import com.example.userresoucemanagement.service.FormulaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/formulas")
public class FormulaController {

    @Autowired
    private FormulaService formulaService;

    @GetMapping
    public List<Formula> getAllFormulas() {
        return formulaService.getAllFormulas();
    }

    @GetMapping("/{id}")
    public Formula getFormulaById(@PathVariable Long id) {
        return formulaService.getFormulaById(id);
    }

    @PostMapping("/add")
    public ResponseEntity<String> addFormula(@RequestBody Formula formula) {
        formulaService.addFormula(formula);
        return ResponseEntity.ok("Formula added successfully");
    }

    @PutMapping
    public ResponseEntity<String> updateFormula(@RequestBody Formula formula) {
        formulaService.updateFormula(formula);
        return ResponseEntity.ok("Formula updated successfully");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteFormula(@PathVariable Long id) {
        formulaService.deleteFormula(id);
        return ResponseEntity.ok("Formula deleted successfully");
    }
}
