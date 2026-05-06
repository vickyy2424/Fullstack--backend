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

import com.example.back.entity.Issue;
import com.example.back.services.IssueSer;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/issues")
@RequiredArgsConstructor
public class IssueCon {

   
    private final IssueSer service;

    @PostMapping
    public Issue create(@RequestBody Issue issue) {
        return service.create(issue);
    }

    @GetMapping
    public List<Issue> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Issue getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @PutMapping("/{id}")
    public Issue update(@PathVariable Long id, @RequestBody Issue issue) {
        return service.update(id, issue);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        service.delete(id);
        return "Issue deleted successfully";
    }
}
