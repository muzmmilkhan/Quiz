package com.example.quizwebsite.domain.dao;

import com.example.quizwebsite.domain.Report;
import com.example.quizwebsite.domain.Submission;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("submissionDao")
public class SubmissionDao extends AbstractDao<Submission> {
    public SubmissionDao() {
        setClazz(Submission.class);
    }

    public Submission getSubmissionById(int id) {
        return findById(id);
    }

    public void addSubmission(Submission submission) {
        add(submission);
    }

    public void addSubmissionWithReport(Submission submission, List<Report> report) {
        Session session = getCurrentSession();
        session.save(submission);
        for (Report r : report) {
            r.setSubmission(submission);
            session.save(r);
        }
    }

    public List<Submission> getAllSubmissions() {
        return getCurrentSession().createQuery("from Submission order by startTime desc").list();
    }

    public List<Submission> getAllSubmissionsByQuizType(int quizTypeId) {
        return getCurrentSession().createSQLQuery("select * from Submission where QuizTypeId = " + quizTypeId + " order by startTime desc").list();
    }

    public List<Submission> getAllSubmissionsByUserId(int userId) {
        return getCurrentSession().createSQLQuery("select * from Submission where UserId = " + userId  + " order by startTime desc").list();
    }

    public List<Submission> getAllSubmissionsByUsername(String username) {
        return getCurrentSession().createSQLQuery("select * from Submission where UserId = (select id from User where username = '" + username + "')").list();
     }

}

