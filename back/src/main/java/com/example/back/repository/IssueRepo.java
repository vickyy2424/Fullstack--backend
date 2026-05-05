package com.example.back.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.back.entity.Issue;

public interface IssueRepo extends JpaRepository<Issue, Long> {
}
