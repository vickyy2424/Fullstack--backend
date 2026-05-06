package com.example.back.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.back.entity.Issue;
import com.example.back.repository.IssueRepo;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class IssueSer {

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

    issue.setType(newIssue.getType());
    issue.setDescription(newIssue.getDescription());
    issue.setSeverity(newIssue.getSeverity());
    issue.setSuggestion(newIssue.getSuggestion());
    issue.setReport(newIssue.getReport());

    return repo.save(issue);
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }
}
