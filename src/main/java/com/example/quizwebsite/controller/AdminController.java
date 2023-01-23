package com.example.quizwebsite.controller;

import com.example.quizwebsite.domain.Submission;
import com.example.quizwebsite.service.FeedbackService;
import com.example.quizwebsite.service.QuizService;
import com.example.quizwebsite.service.SubmissionService;
import com.example.quizwebsite.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@Controller
@RequestMapping("/admin")
@SessionAttributes("submission")
public class AdminController {
    private UserService userService;
    private FeedbackService feedbackService;
    private SubmissionService submissionService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Autowired
    public void setFeedbackService(FeedbackService feedbackService) {
        this.feedbackService = feedbackService;
    }

    @Autowired
    public void setSubmissionService(SubmissionService submissionService) {
        this.submissionService = submissionService;
    }

    @GetMapping("users")
    public String userManagement(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        return "management-users";
    }

    @PostMapping("users/{userId}")
    public String updateUser(@PathVariable Integer userId) {
        userService.updateActive(userId);
        return "redirect:/admin/users";
    }

    @GetMapping("submissions")
    public String submissionManagement(Model model) {
        model.addAttribute("submissions", submissionService.getAllSubmissions());
        return "management-submissions";
    }

    @GetMapping("submissions/user/{userId}")
    public String submissionManagementByUser(@PathVariable Integer userId, Model model) {
        List<Submission> submissions = submissionService.getAllSubmissions();
        // remove all submissions that are not from the user
        for(int i = 0; i < submissions.size(); i++) {
            if(!submissions.get(i).getUser().getId().equals(userId)) {
                submissions.remove(i);
                i--;
            }
        }
        model.addAttribute("submissions", submissions);
        return "management-submissions";
    }

    @GetMapping("submissions/type/{quizTypeId}")
    public String submissionManagementByType(@PathVariable Integer quizTypeId, Model model) {
        List<Submission> submissions = submissionService.getAllSubmissions();

        // remove all submissions that are not from the quiz type
        for(int i = 0; i < submissions.size(); i++) {
            if(!submissions.get(i).getQuizType().getId().equals(quizTypeId)) {
                submissions.remove(i);
                i--;
            }
        }
        model.addAttribute("submissions", submissions);
        return "management-submissions";
    }

    @GetMapping("submissions/{submissionId}")
    public String submissionManagement(@PathVariable Integer submissionId, Model model) {
        model.addAttribute("submission", submissionService.getSubmissionById(submissionId));
        return "management-submission-detail";
    }

    @GetMapping("feedbacks")
    public String feedbackManagement(Model model) {
        model.addAttribute("feedbacks", feedbackService.getAllFeedbacks());
        return "management-feedbacks";
    }
}
