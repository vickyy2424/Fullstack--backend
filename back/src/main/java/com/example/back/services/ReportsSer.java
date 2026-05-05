package com.example.back.services;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.RequestScope;

import com.example.back.entity.Report;
import com.example.back.repository.ReportRepo;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ReportsSer {
    private final ReportRepo repo;

    public Report create(Report report) {
        return repo.save(report);
    }
    
    public List<Report> getAll() {
        return repo.findAll();
    }

    public Report getById(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Report not found"));
    }

    public Report update(Long id, Report newReport) {
        Report report = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Report not found"));

        report.setTitle(newReport.getTitle());
        report.setDescription(newReport.getDescription());
        report.setCreatedAt(newReport.getCreatedAt());
        report.setUser(newReport.getUser());

        return repo.save(report);
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }


    
}


