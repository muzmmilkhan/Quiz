package com.example.quizwebsite.domain.dao;

import com.example.quizwebsite.domain.Report;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("reportDao")
public class ReportDao extends AbstractDao<Report>{
    public ReportDao() {
        setClazz(Report.class);
    }

    public Report getReportById(int id) {
        return findById(id);
    }

    public void addReport(Report report) {
        add(report);
    }

    public List<Report> getAllReports() {
        return getCurrentSession().createQuery("from Report").list();
    }

    public List<Report> getAllReportsBySubmissionId(int submissionId) {
        return getCurrentSession().createSQLQuery("select * from Report where SubmissionId = " + submissionId).list();
    }
}
