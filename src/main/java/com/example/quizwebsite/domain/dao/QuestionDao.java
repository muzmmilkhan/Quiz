package com.example.quizwebsite.domain.dao;

import com.example.quizwebsite.domain.Question;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("questionDao")
public class QuestionDao extends AbstractDao<Question> {
    public QuestionDao() {
        setClazz(Question.class);
    }

    public Question getQuestionById(int id) {
        return findById(id);
    }

    public List<Question> getAllQuestionsByQuizType(int quizTypeId) {
        return getCurrentSession().createSQLQuery("select * from question where QuizTypeId = " + quizTypeId + " order by rand() limit 10").addEntity(Question.class).list();
    }
}

