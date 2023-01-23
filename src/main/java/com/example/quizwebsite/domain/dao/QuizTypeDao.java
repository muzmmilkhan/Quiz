package com.example.quizwebsite.domain.dao;

import com.example.quizwebsite.domain.QuizType;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("quizTypeDao")
public class QuizTypeDao extends AbstractDao<QuizType> {
    public QuizTypeDao() {
        setClazz(QuizType.class);
    }

    public QuizType getQuizTypeById(int id) {
        return findById(id);
    }

    public List<QuizType> getAllQuizTypes() {
        return getCurrentSession().createQuery("from QuizType").list();
    }
}
