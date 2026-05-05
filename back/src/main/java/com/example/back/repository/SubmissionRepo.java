package com.example.back.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.back.entity.Submission;

public interface SubmissionRepo extends JpaRepository<Submission, Long> {
}
