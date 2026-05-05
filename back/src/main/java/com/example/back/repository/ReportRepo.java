package com.example.back.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.back.entity.Report;

public interface ReportRepo extends JpaRepository<Report, Long> {
}