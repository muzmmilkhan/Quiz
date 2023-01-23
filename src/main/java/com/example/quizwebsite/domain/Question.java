package com.example.quizwebsite.domain;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name="question")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Question implements Serializable {
    // three columns: id, QuizTypeId, Description
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "QuizTypeId")
    private QuizType quizType;

    @Column(name="Description")
    private String Description;

    @OneToMany(mappedBy="question", fetch=FetchType.EAGER)
    private List<Choice> choice;
}

