package com.example.quizwebsite.domain;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name="quiztype")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class QuizType implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="Name")
    private String name;

    @Column(name="Difficulty")
    private Integer Difficulty;

    @Column(name="TimeLimit")
    private Integer TimeLimit;

    @Column(name="Image")
    private String Image;

    @Column(name="Description")
    private String description;

    @OneToMany(mappedBy="quizType", fetch=FetchType.LAZY)
    private List<Question> question;

    @OneToMany(mappedBy="quizType")
    private List<Submission> submission;

    @OneToMany(mappedBy="quizType", fetch=FetchType.LAZY)
    private List<Feedback> feedback;
}


