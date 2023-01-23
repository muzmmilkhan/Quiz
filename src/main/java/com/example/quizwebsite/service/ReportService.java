package com.example.quizwebsite.service;

import com.example.quizwebsite.domain.dao.ReportDao;
import com.example.quizwebsite.domain.Report;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ReportService {
    private ReportDao reportDao;

    @Autowired
    @Qualifier("reportDao")
    public void setReportDao(ReportDao reportDao) {
        this.reportDao = reportDao;
    }

    @Transactional
    public Report getReportById(int id) {
        return reportDao.getReportById(id);
    }

    @Transactional
    public void addReport(Report report) {
        reportDao.addReport(report);
    }

    @Transactional
    public void getAllReportsBySubmissionId(int submissionId) {
        reportDao.getAllReportsBySubmissionId(submissionId);
    }
}
