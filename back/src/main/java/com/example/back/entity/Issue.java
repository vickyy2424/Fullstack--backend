package com.example.back.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Issue {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long issueId;

    private String type;
    private String description;
    private String severity;
    private String suggestion;

    @ManyToOne
    @JoinColumn(name = "report_id")
    private Report report;
}