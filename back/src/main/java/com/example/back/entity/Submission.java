package com.example.back.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Entity
@Data
public class Submission {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long submissionId;

    private String language;

    @Lob
    private String codeContent;

    private LocalDateTime submittedAt;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
