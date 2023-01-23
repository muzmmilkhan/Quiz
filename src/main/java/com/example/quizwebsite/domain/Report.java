package com.example.quizwebsite.domain;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name="report")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Report implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "SubmissionId")
    private Submission submission;

    @ManyToOne
    @JoinColumn(name = "QuestionId")
    private Question question;

    @Column(name="selected")
    private String selected;

    @Column(name="Answer")
    private String answer;
}
