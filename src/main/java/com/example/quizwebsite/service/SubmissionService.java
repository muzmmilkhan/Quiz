package com.example.quizwebsite.service;

import com.example.quizwebsite.domain.dao.SubmissionDao;
import com.example.quizwebsite.domain.Report;
import com.example.quizwebsite.domain.Submission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class SubmissionService {
    private SubmissionDao submissionDao;

    @Autowired
    @Qualifier("submissionDao")
    public void setSubmissionDao(SubmissionDao submissionDao) {
        this.submissionDao = submissionDao;
    }

    @Transactional
    public Submission getSubmissionById(int id) {
        return submissionDao.getSubmissionById(id);
    }

    @Transactional
    public void addSubmission(Submission submission) {
        submissionDao.addSubmission(submission);
    }

    @Transactional
    public void addSubmissionWithReport(Submission submission, List<Report> report) {
        submissionDao.addSubmissionWithReport(submission, report);
    }
    @Transactional
    public List<Submission> getAllSubmissions() {
        return submissionDao.getAllSubmissions();
    }

    @Transactional
    public List<Submission> getAllSubmissionsByQuizType(int quizTypeId) {
        return submissionDao.getAllSubmissionsByQuizType(quizTypeId);
    }

    @Transactional
    public List<Submission> getAllSubmissionsByUserId(int userId) {
        return submissionDao.getAllSubmissionsByUserId(userId);
    }
}
