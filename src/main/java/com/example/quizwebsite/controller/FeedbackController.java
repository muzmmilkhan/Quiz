package com.example.quizwebsite.controller;

import com.example.quizwebsite.domain.Feedback;
import com.example.quizwebsite.domain.QuizType;
import com.example.quizwebsite.service.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/")
@SessionAttributes("quizType")
public class FeedbackController {
    private FeedbackService feedbackService;

    @Autowired
    public void setFeedbackService(FeedbackService feedbackService) {
        this.feedbackService = feedbackService;
    }

    @GetMapping("/addfeedback")
    public String addFeedback(Model model) {
        model.addAttribute("feedback", new Feedback());
        return "addfeedback";
    }

    @PostMapping("/addfeedback")
    public String addFeedback(@ModelAttribute("feedback") Feedback feedback, Model model) {
        feedback.setQuizType((QuizType) model.getAttribute("quizType"));
        feedbackService.addFeedback(feedback);
        return "redirect:/";
    }
}
