package com.example.quizwebsite.domain;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "choice")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Choice implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "QuestionId")
    private Question question;

    @Column(name = "Description")
    private String Description;

    @Column(name = "IsAnswer")
    private Boolean IsCorrect;
}
