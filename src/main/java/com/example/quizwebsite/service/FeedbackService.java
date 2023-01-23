package com.example.quizwebsite.service;

import com.example.quizwebsite.domain.dao.FeedbackDao;
import com.example.quizwebsite.domain.Feedback;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class FeedbackService {
    private FeedbackDao feedbackDao;

    @Autowired
    @Qualifier("feedbackDao")
    public void setFeedbackDao(FeedbackDao feedbackDao) {
        this.feedbackDao = feedbackDao;
    }

    @Transactional
    public Feedback getFeedbackById(int id) {
        return feedbackDao.getFeedbackById(id);
    }

    @Transactional
    public List<Feedback> getAllFeedbacks() {
        return feedbackDao.getAllFeedbacks();
    }

    @Transactional
    public List<Feedback> getAllFeedbacksbyQuizTypeId(int quizTypeId) {
        return feedbackDao.getAllFeedbacksbyQuizTypeId(quizTypeId);
    }



    @Transactional
    public void addFeedback(Feedback feedback) {
        feedbackDao.addFeedback(feedback);
    }
}
