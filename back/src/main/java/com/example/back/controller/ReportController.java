package com.example.back.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.back.entity.Report;
import com.example.back.services.ReportsSer;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/reports")
@RequiredArgsConstructor
public class ReportController {

    
    private final ReportsSer service;

    @PostMapping
    public Report create(@RequestBody Report report) {
        return service.create(report);
    }

    @GetMapping
    public List<Report> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Report getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @PutMapping("/{id}")
    public Report update(@PathVariable Long id, @RequestBody Report report) {
        return service.update(id, report);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        service.delete(id);
        return "Report deleted successfully";
    }
}