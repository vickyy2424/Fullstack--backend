package com.example.back.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;

import com.example.back.entity.Submission;
import com.example.back.services.SubmissionSer;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/submissions")
@RequiredArgsConstructor
public class SubmissionCon {

    
    private final SubmissionSer service;

    @PostMapping
    public Submission create(@RequestBody Submission submission) {
        return service.create(submission);
    }

    @GetMapping
    public List<Submission> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Submission getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @PutMapping("/{id}")
    public Submission update(@PathVariable Long id, @RequestBody Submission submission) {
        return service.update(id, submission);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        service.delete(id);
        return "Submission deleted successfully";
    }
}
