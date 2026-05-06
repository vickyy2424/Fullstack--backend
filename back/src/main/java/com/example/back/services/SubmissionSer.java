package com.example.back.services;


import org.springframework.stereotype.Service;

import java.util.List;

import com.example.back.entity.Submission;
import com.example.back.repository.SubmissionRepo;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SubmissionSer {

    
    private final SubmissionRepo repo;

    public Submission create(Submission submission) {
        return repo.save(submission);
    }

    public List<Submission> getAll() {
        return repo.findAll();
    }

    public Submission getById(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Submission not found"));
    }

    public Submission update(Long id, Submission newSubmission) {
        Submission submission = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Submission not found"));

        submission.setLanguage(newSubmission.getLanguage());
        submission.setCodeContent(newSubmission.getCodeContent());
        submission.setSubmittedAt(newSubmission.getSubmittedAt());
        submission.setUser(newSubmission.getUser());

        return repo.save(submission);
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }
}