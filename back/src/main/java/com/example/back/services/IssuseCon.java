package com.example.back.services;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class IssuseCon {

    private final IssueRepo repo;

    public Issue create(Issue issue) {
        return repo.save(issue);
    }

    public List<Issue> getAll() {
        return repo.findAll();
    }

    public Issue getById(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Issue not found"));
    }
    
    public Issue update(Long id, Issue newIssue) {
        Issue issue = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Issue not found"));

        issue.setTitle(newIssue.getTitle());
        issue.setDescription(newIssue.getDescription());
        issue.setCreatedAt(newIssue.getCreatedAt());
        issue.setUser(newIssue.getUser());

        return repo.save(issue);
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }
}
