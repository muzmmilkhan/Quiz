package com.example.quizwebsite.domain;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name="user")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="username")
    private String username;

    @Column(name="password")
    private String password;

    @Column(name="email")
    private String email;

    @Column(name="isAdmin")
    private boolean isAdmin;

    @Column(name="isActive")
    private boolean isActive;

    @OneToMany(mappedBy="user")
    private List<Submission> submission;

    public User(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.isAdmin = false;
        this.isActive = true;
    }

    public boolean getIsActive() {
        return isActive;
    }

    public boolean getIsAdmin() {
        return isAdmin;
    }
}
