package com.example.quizwebsite.controller;

import com.example.quizwebsite.domain.Submission;
import com.example.quizwebsite.domain.Report;
import com.example.quizwebsite.domain.User;
import com.example.quizwebsite.service.ReportService;
import com.example.quizwebsite.service.SubmissionService;
import com.example.quizwebsite.util.TempAnswerContainer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.text.DateFormat;
import java.util.List;
import java.util.Objects;

@Controller
@RequestMapping("/")
@SessionAttributes({"reports", "submission"})
public class SubmissionController {
    private SubmissionService submissionService;
    private ReportService reportService;

    @Autowired
    public void setSubmissionService(SubmissionService submissionService) {
        this.submissionService = submissionService;
    }

    @GetMapping("/submissions")
    public String getAllSubmissions(Model model) {
        List<Submission> submissions = submissionService.getAllSubmissions();
        model.addAttribute("submissions", submissions);
        return "submission";
    }

    @GetMapping("/submissions/{submissionId}")
    public String getSubmissionById(@PathVariable int submissionId, Model model) {
        Submission submission = submissionService.getSubmissionById(submissionId);
        model.addAttribute("submission", submission);
        return "submission";
    }

    @GetMapping("/submission/user/{userId}")
    public String getAllSubmissionsByUserId(@PathVariable int userId, Model model) {
        List<Submission> submissions = submissionService.getAllSubmissionsByUserId(userId);
        model.addAttribute("submissions", submissions);
        return "submission";
    }

    @GetMapping("/submission/quiztype/{quizTypeId}")
    public String getAllSubmissionsByQuizType(@PathVariable int quizTypeId, Model model) {
        List<Submission> submissions = submissionService.getAllSubmissionsByQuizType(quizTypeId);
        model.addAttribute("submissions", submissions);
        return "submission";
    }

    @PostMapping("/result")
    public String submitQuiz(
            HttpServletRequest request,
            @ModelAttribute("tempAnswer") TempAnswerContainer tempAnswer,
            Model model) {
        // insert tempAnswer into Reports' selected
        List<Report> reports = (List<Report>) model.getAttribute("reports");
        reports.get(0).setSelected(tempAnswer.getAnswer1());
        reports.get(1).setSelected(tempAnswer.getAnswer2());
        reports.get(2).setSelected(tempAnswer.getAnswer3());
        reports.get(3).setSelected(tempAnswer.getAnswer4());
        reports.get(4).setSelected(tempAnswer.getAnswer5());
        reports.get(5).setSelected(tempAnswer.getAnswer6());
        reports.get(6).setSelected(tempAnswer.getAnswer7());
        reports.get(7).setSelected(tempAnswer.getAnswer8());
        reports.get(8).setSelected(tempAnswer.getAnswer9());
        reports.get(9).setSelected(tempAnswer.getAnswer10());

        // compare selected with answer
        int score = 0;

        for (Report report : reports) {
            if(Objects.equals(report.getSelected(), report.getAnswer())) {
                score++;
            }
        }

        Submission submission = (Submission) model.getAttribute("submission");
        User user = (User) request.getSession().getAttribute("user");

        submission.setUser(user);
        submission.setQuizType(reports.get(0).getQuestion().getQuizType());
        if(score > 6) {
            submission.setPass(true);
        }
        else {
            submission.setPass(false);
        }
        submission.setEndTime(DateFormat.getInstance().format(System.currentTimeMillis()));
        submission.setReport(reports);

        submissionService.addSubmissionWithReport(submission, reports);

        model.addAttribute("score", score);
        model.addAttribute("reports", reports);

        return "result";
    }
}
