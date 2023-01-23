package com.example.quizwebsite.domain.dao;

import com.example.quizwebsite.domain.Feedback;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("feedbackDao")
public class FeedbackDao extends AbstractDao<Feedback> {
    public FeedbackDao() {
        setClazz(Feedback.class);
    }

    public Feedback getFeedbackById(int id) {
        return findById(id);
    }

    public List<Feedback> getAllFeedbacks() {
        return getCurrentSession().createQuery("from Feedback").list();
    }

    public List<Feedback> getAllFeedbacksbyQuizTypeId(int quizTypeId) {
        return getCurrentSession().createSQLQuery("select * from Feedback where QuizTypeId = " + quizTypeId).list();
    }

    public void addFeedback(Feedback feedback) {
        add(feedback);
    }
}
