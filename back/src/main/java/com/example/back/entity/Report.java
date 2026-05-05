package com.example.back.entity;



import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Report {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reportId;

    private int overallScore;
    private int readabilityScore;
    private int maintainabilityScore;
    private int complexityScore;

    @ManyToOne
    @JoinColumn(name = "submission_id")
    private Submission submission;
}
