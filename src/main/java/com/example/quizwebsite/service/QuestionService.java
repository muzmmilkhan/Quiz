package com.example.quizwebsite.service;

import com.example.quizwebsite.domain.dao.QuestionDao;
import com.example.quizwebsite.domain.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class QuestionService {
    private QuestionDao questionDao;

    @Autowired
    @Qualifier("questionDao")
    public void setQuestionDao(QuestionDao questionDao) {
        this.questionDao = questionDao;
    }

    @Transactional
    public Question getQuestionById(int id) {
        return questionDao.getQuestionById(id);
    }

    @Transactional
    public List<Question> getAllQuestionsByQuizType(int quizTypeId) {
        return questionDao.getAllQuestionsByQuizType(quizTypeId);
    }
}
