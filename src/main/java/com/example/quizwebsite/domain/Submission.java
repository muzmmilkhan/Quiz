package com.example.quizwebsite.domain;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name="submission")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Submission implements Serializable {
    // 6 columns: id, UserId, QuizTypeId, StartTime, EndTime, Pass
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name="UserId")
    private User user;

    @ManyToOne
    @JoinColumn(name = "QuizTypeId")
    private QuizType quizType;

    @Column(name="StartTime")
    private String startTime;

    @Column(name="EndTime")
    private String endTime;

    @Column(name="Pass")
    private Boolean pass;

    @OneToMany(mappedBy="submission", fetch=FetchType.EAGER)
    private List<Report> report;

    public User getUser() {
        return user;
    }

    public QuizType getQuizType() {
        return quizType;
    }
}
