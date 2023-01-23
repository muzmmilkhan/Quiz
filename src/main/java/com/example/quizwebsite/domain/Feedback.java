package com.example.quizwebsite.domain;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="feedback")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Feedback implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "QuizTypeId")
    private QuizType quizType;

    @Column(name="Rating")
    private Integer rating;

    @Column(name="Description")
    private String description;
}
