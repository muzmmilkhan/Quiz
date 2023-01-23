package com.example.quizwebsite.service;

import com.example.quizwebsite.domain.dao.QuizTypeDao;
import com.example.quizwebsite.domain.QuizType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class QuizService {
    private QuizTypeDao quizTypeDao;

    @Autowired
    @Qualifier("quizTypeDao")
    public void setQuizTypeDao(QuizTypeDao quizTypeDao) {
        this.quizTypeDao = quizTypeDao;
    }

    @Transactional
    public QuizType getQuizTypeById(int id) {
        return quizTypeDao.getQuizTypeById(id);
    }

    @Transactional
    public List<QuizType> getAllQuizTypes() {
        return quizTypeDao.getAllQuizTypes();
    }
}
